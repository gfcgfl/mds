package com.zju.nir.report.mapper;

import com.zju.nir.report.entity.ReportCreationStatus;
import com.zju.nir.report.entity.ReportRecordDO;
import com.zju.nir.report.entity.ReportRecordDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReportRecordMapper {
    long countByExample(ReportRecordDOExample example);

    int deleteByExample(ReportRecordDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportRecordDO record);

    int insertSelective(ReportRecordDO record);

    List<ReportRecordDO> selectByExample(ReportRecordDOExample example);

    ReportRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportRecordDO record, @Param("example") ReportRecordDOExample example);

    int updateByExample(@Param("record") ReportRecordDO record, @Param("example") ReportRecordDOExample example);

    int updateByPrimaryKeySelective(ReportRecordDO record);

    int updateByPrimaryKey(ReportRecordDO record);

    List<ReportCreationStatus> listReportCreationStatusByPatientId(Integer patientId);
}