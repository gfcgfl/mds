package com.zju.nir.rest.mapper;

import com.zju.nir.rest.entity.RestTaskDO;
import com.zju.nir.rest.entity.RestTaskDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RestTaskMapper {
    long countByExample(RestTaskDOExample example);

    int deleteByExample(RestTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RestTaskDO record);

    int insertSelective(RestTaskDO record);

    List<RestTaskDO> selectByExample(RestTaskDOExample example);

    RestTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RestTaskDO record, @Param("example") RestTaskDOExample example);

    int updateByExample(@Param("record") RestTaskDO record, @Param("example") RestTaskDOExample example);

    int updateByPrimaryKeySelective(RestTaskDO record);

    int updateByPrimaryKey(RestTaskDO record);
}