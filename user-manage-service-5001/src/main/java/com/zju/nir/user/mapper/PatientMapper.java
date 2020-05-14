package com.zju.nir.user.mapper;

import com.zju.nir.user.entity.PatientDO;
import com.zju.nir.user.entity.PatientDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PatientMapper {
    long countByExample(PatientDOExample example);

    int deleteByExample(PatientDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PatientDO record);

    int insertSelective(PatientDO record);

    List<PatientDO> selectByExample(PatientDOExample example);

    PatientDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PatientDO record, @Param("example") PatientDOExample example);

    int updateByExample(@Param("record") PatientDO record, @Param("example") PatientDOExample example);

    int updateByPrimaryKeySelective(PatientDO record);

    int updateByPrimaryKey(PatientDO record);

    Integer selectPatientAdhdTypeById(Integer patientId);

    void addAdhdType(@Param("patientId") Integer patientId, @Param("adhdType") Integer adhdType);
}