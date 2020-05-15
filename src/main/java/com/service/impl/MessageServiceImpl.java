package com.service.impl;

import com.constant.CommonConstant;
import com.dao.MessageMapper;
import com.entity.Message;
import com.entity.MessageExample;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.MessageService;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageMapper messageMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

        MessageExample example = new MessageExample();
        if(!StringUtils.isBlank(fuzzy)){
            example.or().andTitleLike("%" + fuzzy + "%");
            example.or().andContentLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStateEqualTo("0000");
        }
        example.setOrderByClause("`create_time` DESC");

        List<Message> list = messageMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> updateInfoDataByAdmin(Message message) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(message.getId());

        messageMapper.updateByExampleSelective(message, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> addInfoDataByAdmin(Message message, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        HttpSession session = request.getSession();

        message.setState("0000");
        message.setCreateUser((String) session.getAttribute(CommonConstant.ADMIN_SESSION_NAME));
        message.setCreateTime(new Date());
        messageMapper.insert(message);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Message> adminList = messageMapper.selectByExample(example);

        for (Message message : adminList) {
            message.setState("9999");
            messageMapper.updateByPrimaryKey(message);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Message> fetchNewInfoData() {
        return messageMapper.fetchNewInfoData();
    }

    @Override
    public PageInfo<Message> fetchInfoData(Integer page, Integer size,String fuzzy) {

            PageInfo<Message> messagePageInfo = PageHelper.startPage(page, size).doSelectPageInfo(new ISelect() {
                @Override
                public void doSelect() {
                    if(page!=null && size!=null) {
                    MessageExample messageExample = new MessageExample();
                    if(!StringUtils.isBlank(fuzzy)){
                        messageExample.or().andTitleLike("%" + fuzzy + "%");
                        messageExample.or().andContentLike("%" + fuzzy + "%");
                        if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                            messageExample.or().andStateLike("%" + fuzzy + "%");
                        }
                    }
                        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                            messageExample.createCriteria().andStateEqualTo("0000");
                        }

                        messageExample.setOrderByClause("`create_time` DESC");

                        messageMapper.selectByExample(messageExample);
                  }
                }
            });

        return messagePageInfo;
    }
}
