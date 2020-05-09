package com.zju.nir.stroop.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.stroop.entity.StroopTaskDO;

/**
 * @author xiaoguo
 */
public interface StroopTaskService {

    /**
     * 添加stroop任务
     * @param stroopDataDTO
     * @return
     */
    ReturnResult<Object> addStroopTask(TaskDataDTO stroopDataDTO);

    StroopTaskDO getStroopTask(Integer collectId, Integer patientId);
}
