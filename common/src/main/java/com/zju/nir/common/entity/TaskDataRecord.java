package com.zju.nir.common.entity;

import com.zju.nir.common.xenum.TaskTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 某一个任务的任务数据
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TaskDataRecord {

    private Integer taskId;

    private String taskName;

    private Date startTime;

    private Date endTime;

    /**
     * 任务的一些得分之类的信息
     */
    private LinkedHashMap<String, Object> records;

    /**
     * 血氧文件的存放路径（可能是一个url或者一个本地存放路径）
     */
    private String filePath;


}
