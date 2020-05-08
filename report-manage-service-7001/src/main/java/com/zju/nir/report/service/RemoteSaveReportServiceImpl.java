package com.zju.nir.report.service;

import com.zju.nir.report.entity.ReportMetaData;
import com.zju.nir.report.entity.ReportStorageStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 将报告远程存储的ReportService具体实现类
 * @author xiaoguo
 */

public class RemoteSaveReportServiceImpl extends AbstractReportService {



    protected ReportStorageStatus storeReportFile(File reportFile, ReportMetaData reportMetaData) {

        //todo  这里先模拟一下存储成功
        return new ReportStorageStatus().setPath("https://arxiv.org/pdf/1706.03762.pdf")
                .setReportName(reportMetaData.getCollectId() + "-" + reportMetaData.getPatientId() + "-报告.pdf")
                .setStorageMode(ReportStorageStatus.STORAGE_MODE_REMOTE)
                .setSucceed(true);
    }

    protected String getReportRedirectPath(ReportStorageStatus reportStorageStatus) {
        return reportStorageStatus.getPath();
    }
}
