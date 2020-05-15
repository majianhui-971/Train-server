package com.dao;

import com.entity.Drive;
import com.entity.DriveExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DriveMapper {
    int countByExample(DriveExample example);

    int deleteByExample(DriveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Drive record);

    int insertSelective(Drive record);

    List<Drive> selectByExample(DriveExample example);

    Drive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drive record, @Param("example") DriveExample example);

    int updateByExample(@Param("record") Drive record, @Param("example") DriveExample example);

    int updateByPrimaryKeySelective(Drive record);

    int updateByPrimaryKey(Drive record);
}