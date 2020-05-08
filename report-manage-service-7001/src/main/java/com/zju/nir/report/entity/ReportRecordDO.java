package com.zju.nir.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportRecordDO {
    private Integer id;

    private Integer patientId;

    private Integer collectId;

    private Date creatTime;

    private Integer status;

    private String reportPath;

}