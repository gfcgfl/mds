package com.zju.nir.collect.mapper;

import com.zju.nir.collect.entity.xdo.CollectRecordDO;
import com.zju.nir.collect.entity.xdo.CollectRecordDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CollectRecordMapper {
    long countByExample(CollectRecordDOExample example);

    int deleteByExample(CollectRecordDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CollectRecordDO record);

    int insertSelective(CollectRecordDO record);

    List<CollectRecordDO> selectByExample(CollectRecordDOExample example);

    CollectRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CollectRecordDO record, @Param("example") CollectRecordDOExample example);

    int updateByExample(@Param("record") CollectRecordDO record, @Param("example") CollectRecordDOExample example);

    int updateByPrimaryKeySelective(CollectRecordDO record);

    int updateByPrimaryKey(CollectRecordDO record);
}