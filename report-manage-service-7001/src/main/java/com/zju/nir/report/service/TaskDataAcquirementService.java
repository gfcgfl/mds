package com.zju.nir.report.service;

import com.zju.nir.report.entity.ReportData;
import com.zju.nir.report.entity.ReportMetaData;

/**
 * @author xiaoguo
 */
public interface TaskDataAcquirementService {


    ReportData getReportNeededTaskData(ReportMetaData reportMetaData);


}
