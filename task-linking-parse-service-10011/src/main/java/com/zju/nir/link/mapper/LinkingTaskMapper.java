package com.zju.nir.link.mapper;

import com.zju.nir.link.entity.LinkingTaskDO;
import com.zju.nir.link.entity.LinkingTaskDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LinkingTaskMapper {
    long countByExample(LinkingTaskDOExample example);

    int deleteByExample(LinkingTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LinkingTaskDO record);

    int insertSelective(LinkingTaskDO record);

    List<LinkingTaskDO> selectByExample(LinkingTaskDOExample example);

    LinkingTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LinkingTaskDO record, @Param("example") LinkingTaskDOExample example);

    int updateByExample(@Param("record") LinkingTaskDO record, @Param("example") LinkingTaskDOExample example);

    int updateByPrimaryKeySelective(LinkingTaskDO record);

    int updateByPrimaryKey(LinkingTaskDO record);
}