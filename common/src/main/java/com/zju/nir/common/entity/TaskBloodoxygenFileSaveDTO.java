package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TaskBloodoxygenFileSaveDTO {

    private Integer taskId;
    private Integer patientId;
    private Integer collectId;
    private String startTime;
    private String endTime;

    /**
     * 任务血氧数据文件序列化为字符串（例如采用base64）结果
     */
    private String fileString;
}
