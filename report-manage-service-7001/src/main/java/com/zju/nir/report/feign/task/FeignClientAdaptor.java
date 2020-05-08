package com.zju.nir.report.feign.task;

import com.zju.nir.common.entity.TaskDataRecord;

/**
 * @author xiaoguo
 */
public interface FeignClientAdaptor {

    /**
     * 获取相应任务的任务数据
     * @param collectId
     * @param patientId
     * @return
     */
    TaskDataRecord getTaskData(Integer collectId, Integer patientId) throws Exception;
}
