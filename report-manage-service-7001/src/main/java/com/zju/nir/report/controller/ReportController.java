package com.zju.nir.report.controller;

import com.alibaba.fastjson.JSONObject;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.utils.DateUtils;
import com.zju.nir.report.entity.ReportCreationStatus;
import com.zju.nir.report.entity.ReportInfoVO;
import com.zju.nir.report.entity.ReportMessage;
import com.zju.nir.report.entity.ReportMetaData;
import com.zju.nir.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoguo
 */
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;


    /**
     * 获取可以生成的报告（包括已经生成的和尚未生成的）
     * @return
     */
    @GetMapping("/report/{patientId}")
    ReturnResult<ReportInfoVO> getAvailableReport(@PathVariable("patientId") Integer patientId) {

        List<ReportCreationStatus> reportCreationStatus;
        try {
            reportCreationStatus = reportService.listReportCreationStatusByPatientId(patientId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.DB_ERROR_CODE, "查询报告生成状态失败", null);
        }

        ReportInfoVO reportInfoVO = new ReportInfoVO();
        List<ReportCreationStatus> created = new ArrayList<>(3);
        List<ReportCreationStatus> notCreated = new ArrayList<>(3);
        for (ReportCreationStatus status : reportCreationStatus) {
            Boolean createReport = status.getCreateReport();
            if (Boolean.TRUE.equals(createReport)) {
                created.add(status);
            } else {
                notCreated.add(status);
            }
        }
        reportInfoVO.setCreated(created)
                .setNotCreated(notCreated).
                setPatientId(patientId);
        return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "成功", reportInfoVO);
    }


    /**
     * 根据 报告相关的信息 生成对应的报告，返回重定向路径
     * @param reportMeta 报告相关的一些参数信息，json格式，对应的实体是：{@link ReportMetaData}
     */
    @PostMapping("/report/create")
    public ReturnResult<String> createReport(String reportMeta) {

        ReportMetaData reportMetaData = parseJson(reportMeta);

        ReportMessage reportMessage = reportService.createReport(reportMetaData);
        boolean flag = false;
        if (reportMessage.getCreated()) {
            return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "", reportMessage.getRedirectPath());
        }
        return new ReturnResult<>(ReturnResult.FAIL_CODE, "", null);
    }

    private ReportMetaData parseJson(String reportMeta) {

        ReportMetaData metaData = new ReportMetaData();
        JSONObject jsonObject = JSONObject.parseObject(reportMeta);
        metaData.setCollectId(jsonObject.getInteger("collectId"))
                .setPatientId(jsonObject.getInteger("patientId"))
                .setDoctorId(jsonObject.getInteger("doctorId"))
                .setStartTime(DateUtils.dateStringToDate(jsonObject.getString("startTime")))
                .setEndTime(DateUtils.dateStringToDate(jsonObject.getString("endTime")));
        return metaData;

    }

}
