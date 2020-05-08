package com.zju.nir.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportInfoVO {


    private Integer patientId;

    /**
     * 已经生成的报告对应着哪些次采集
     */
    private List<ReportCreationStatus> created;

    /**
     * 还未生成报告的采集轮次
     */
    private List<ReportCreationStatus> notCreated;
}
