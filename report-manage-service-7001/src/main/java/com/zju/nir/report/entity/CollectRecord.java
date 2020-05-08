package com.zju.nir.report.entity;

import com.alibaba.druid.filter.AutoLoad;
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
public class CollectRecord {

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
}
