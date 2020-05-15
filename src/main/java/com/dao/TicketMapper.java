package com.dao;

import com.entity.Ticket;
import com.entity.TicketExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TicketMapper {
    int countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    List<Ticket> selectTicketInfos(@Param("startSite") String startSite,@Param("endSite") String endSite,
                                   @Param("startTime") String startTime);

    List<Ticket> selectInfoDataByAdmin(@Param("fuzzy") String fuzzy);

    List<Ticket> fetchNewInfoData();

    void updateTicketNumber(@Param("ticketNumber") Integer ticketNumber,@Param("id") Integer id);

}