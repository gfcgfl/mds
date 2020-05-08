package com.zju.nir.report.service;

import com.zju.nir.report.entity.ReportCreationStatus;
import com.zju.nir.report.entity.ReportMessage;
import com.zju.nir.report.entity.ReportMetaData;
import com.zju.nir.report.entity.ReportRecordDO;

import java.util.List;

/**
 * @author xiaoguo
 */
public interface ReportService {

    /**
     * 根据patientId获取已经生成的报告
     * @param patientId
     * @return
     */
    List<ReportRecordDO> listCreatedReportsByPatientId(Integer patientId);


    /**
     * 获取某个患者所进行的每一次采集轮次的报告的生成状态
     * @param patientId
     * @return
     */
    List<ReportCreationStatus> listReportCreationStatusByPatientId(Integer patientId) throws Exception;


    /**
     * 根据 采集轮次 id 和患者id 生成对应的报告
     * @param reportMetaData 报告相关元信息
     * @return
     */
    ReportMessage createReport(ReportMetaData reportMetaData);

}
