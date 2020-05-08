package com.zju.nir.common.entity;

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
public class ReportFileSaveDTO {

    /**
     * 每个报告对应着一次采集，下面的两个字段标记采集的标号（也就是哪一次采集）
     */
    private Integer collectId;

    private Integer patientId;

    private Integer doctorId;

    /**
     * 每个报告对应着一次采集，下面的两个字段标记采集过程的开始结束时间
     */
    private Date collectStartTime;

    private Date collectEndTime;

    /**
     * 报告文件的字节
     */
    private byte[] fileBytes;

}
