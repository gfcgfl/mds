package com.zju.nir.stroop.mapper;

import com.zju.nir.stroop.entity.StroopTaskDO;
import com.zju.nir.stroop.entity.StroopTaskDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StroopTaskMapper {
    long countByExample(StroopTaskDOExample example);

    int deleteByExample(StroopTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StroopTaskDO record);

    int insertSelective(StroopTaskDO record);

    List<StroopTaskDO> selectByExample(StroopTaskDOExample example);

    StroopTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StroopTaskDO record, @Param("example") StroopTaskDOExample example);

    int updateByExample(@Param("record") StroopTaskDO record, @Param("example") StroopTaskDOExample example);

    int updateByPrimaryKeySelective(StroopTaskDO record);

    int updateByPrimaryKey(StroopTaskDO record);
}