package com.service.impl;

import com.constant.CommonConstant;
import com.dao.CommentMapper;
import com.dao.CustomerMapper;
import com.entity.Comment;
import com.entity.CommentExample;
import com.entity.Customer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.CommentService;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    CustomerMapper customerMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

        CommentExample example = new CommentExample();
        if (!StringUtils.isBlank(fuzzy)) {
            example.or().andCNameLike("%" + fuzzy + "%");
            if ((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)) {
                example.or().andStateLike("%" + fuzzy + "%");
            }
            example.or().andParentIdEqualTo(Integer.valueOf(fuzzy));
            example.or().andContentLike(fuzzy);
        }

        if (!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)) {
            example.createCriteria().andStateEqualTo("0000");
        }
        example.setOrderByClause("`create_time` DESC");
        List<Comment> list = commentMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if (!StringUtils.isBlank(id)) {
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Comment> infoList = commentMapper.selectByExample(example);

        for (Comment comment : infoList) {
            comment.setState("9999");
            commentMapper.updateByPrimaryKey(comment);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Comment> fetchNewInfoData() {
        return commentMapper.fetchNewInfoData();
    }

    @Override
    public List<Comment> getTreeData() {

        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo("0000");

        List<Comment> allList = commentMapper.selectByExample(example);

        toRecursionList(null, allList);

        return allList;
    }

    @Override
    public List<Comment> fetchAllInfoData() {

        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo("0000");
        criteria.andParentIdEqualTo(0);
        example.setOrderByClause("`create_time` DESC");
        List<Comment> rootList = commentMapper.selectByExample(example);

        for(Comment comment : rootList){
            List<Comment> childList = commentMapper.selectByIndexId(comment.getId());
            for(Comment childComment : childList){
                if(childComment.getParentId() != null && childComment.getParentId() != 0){
                    Comment commentParent = commentMapper.selectByPrimaryKey(childComment.getParentId());
                    if(commentParent != null){
                       childComment.setpName(commentParent.getcName());
                    }
                }
            }

            comment.setChildrenList(childList);
        }

        return rootList;

    }

    @Override
    public Map<String, Object> addInfoData(Comment comment, HttpServletRequest request) {

        Map<String, Object> resultMap = new HashMap<>();

        HttpSession session = request.getSession();

        if(session.getAttribute(CommonConstant.USER_SESSION_ID) != null){
            comment.setState("0000");
            Integer userId = (Integer)session.getAttribute(CommonConstant.USER_SESSION_ID);
            Customer customer = customerMapper.selectByPrimaryKey(userId);
            if(customer.getEmail() != null){
                comment.setcName(customer.getEmail());
            }
            if(customer.getUsername() != null){
                comment.setcName(customer.getUsername());
            }
            comment.setcId(String.valueOf(userId));
            comment.setCreateTime(new Date());
            try {
                commentMapper.insert(comment);
                resultMap.put("type", CommonConstant.SUCCESS_CODE);
                resultMap.put("message", CommonConstant.SUCCESS_MSG);
            }catch (Exception e){
                resultMap.put("type", CommonConstant.FAIL_CODE);
                resultMap.put("message", CommonConstant.FAIL_MSG);
            }
        }


        return resultMap;
    }

    /**
     * 递归评论
     */
    private List<Comment> toRecursionList(Comment comment, List<Comment> list) {
        if (comment == null) {
            if (list == null || list.size() == 0) {
                return new ArrayList<>();
            }

            List<Comment> fartherList = new ArrayList<>();
            for (Comment fartherComment : list) {
                if (fartherComment.getParentId() == null) {
                    fartherList.add(fartherComment);
                }
            }

            //递归查询并设置子级别的评论集合
            for (Comment fartherComment : fartherList) {
                List<Comment> sonList = toRecursionList(fartherComment, list);
                fartherComment.setChildrenList(sonList);
            }
            return fartherList;
        } else {

            List<Comment> sonList = new ArrayList<>();
            for (Comment commentChildren : list) {
                if (commentChildren.getParentId() != null && commentChildren.getParentId().equals(comment.getId())) {
                    sonList.add(commentChildren);
                }
            }
            //设置子级别的评论集合
            comment.setChildrenList(sonList);

            //递归查询并设置子级别的评论集合
            for (Comment sonComment : sonList) {
                List<Comment> nextSonList = toRecursionList(sonComment, list);
                sonComment.setChildrenList(nextSonList);
            }
            return sonList;
        }
    }

}
