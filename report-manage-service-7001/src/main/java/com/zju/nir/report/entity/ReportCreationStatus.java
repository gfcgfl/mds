package com.zju.nir.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportCreationStatus {

    private Integer collectId;

    private Integer patientId;

    private Integer doctorId;

    private Date startTime;

    private Date endTime;

//    private Date createTime;

    /**
     * 是否已经生成对应的报告
     */
    private Boolean createReport;

    private Integer reportId;

    /**
     * 报告是否成功生成
     */
    private Integer status;

    private String reportPath;


}
