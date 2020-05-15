package com.dao;

import com.entity.Order;
import com.entity.OrderExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectInfoDataByAdmin(String fuzzy);

    List<Order> selectOrderInfoOne(@Param("id") int id, @Param("fuzzy") String fuzzy);

    List<Order> selectOrderInfoTwo(@Param("id") int id, @Param("fuzzy") String fuzzy);

    List<Order> selectOrderInfoThree(@Param("id") int id, @Param("fuzzy") String fuzzy);

    List<Order> selectTicketInfo( @Param("id") int id);

    String selectStartTimeById(@Param("ticketId") Integer ticketId);

    List<Order> selectOrderInfoFour(@Param("id")Integer userId, @Param("fuzzy")String fuzzy);
}
