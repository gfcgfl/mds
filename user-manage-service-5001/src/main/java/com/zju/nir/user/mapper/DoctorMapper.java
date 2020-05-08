package com.zju.nir.user.mapper;

import com.zju.nir.user.entity.DoctorDO;
import com.zju.nir.user.entity.DoctorDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DoctorMapper {
    long countByExample(DoctorDOExample example);

    int deleteByExample(DoctorDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DoctorDO record);

    int insertSelective(DoctorDO record);

    List<DoctorDO> selectByExample(DoctorDOExample example);

    DoctorDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DoctorDO record, @Param("example") DoctorDOExample example);

    int updateByExample(@Param("record") DoctorDO record, @Param("example") DoctorDOExample example);

    int updateByPrimaryKeySelective(DoctorDO record);

    int updateByPrimaryKey(DoctorDO record);
}