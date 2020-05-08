package com.zju.nir.report.service;

import com.itextpdf.text.DocumentException;
import com.zju.nir.report.entity.ReportData;

import java.io.File;
import java.io.IOException;

/**
 * @author xiaoguo
 */
public interface ReportCreateService {

    /**
     * 根据 reportData数据创建pdf报告文件
     * @param reportData
     * @return
     */
    File createPdfReport(ReportData reportData) throws IOException, DocumentException;
}
