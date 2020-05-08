package com.zju.nir.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**用于传输任务数据的对象
 * @author xiaoguo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TaskDataDTO {

    private Integer taskId;
    private Integer patientId;
    private Integer collectId;
    private String startTime;
    private String endTime;

    /**
     * 任务血氧数据文件序列化结果
     */
    private String fileString;

    /**
     * 不同的任务可能对应着不同的对象（ReyTask、LinkingTask等），
     * 这里面存放的是每个任务的得分、计时情况
     */
    private Object data;




}
