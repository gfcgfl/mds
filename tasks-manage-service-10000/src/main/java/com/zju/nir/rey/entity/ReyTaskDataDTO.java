package com.zju.nir.rey.entity;

import com.zju.nir.common.entity.ReyTask;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
public class ReyTaskDataDTO {

    private Integer taskId;
    private Integer patientId;
    private Integer collectId;
    private String startTime;
    private String endTime;

    /**
     * 任务血氧数据文件序列化结果
     */
    private byte[] fileBytes;

    /**
     * 不同的任务可能对应着不同的对象（ReyTask、LinkingTask等），
     * 这里面存放的是每个任务的得分、计时情况
     */
    private ReyTask data;
}
