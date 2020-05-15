package com.dao;

import com.entity.Line;
import com.entity.LineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LineMapper {
    int countByExample(LineExample example);

    int deleteByExample(LineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Line record);

    int insertSelective(Line record);

    List<Line> selectByExample(LineExample example);

    Line selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Line record, @Param("example") LineExample example);

    int updateByExample(@Param("record") Line record, @Param("example") LineExample example);

    int updateByPrimaryKeySelective(Line record);

    int updateByPrimaryKey(Line record);

    List<Line> selectInfoDataByAdmin(String fuzzy);
}