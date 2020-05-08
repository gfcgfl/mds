package com.zju.nir.rey.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.rey.entity.ReyTaskDO;
import com.zju.nir.rey.entity.ReyTaskDataDTO;

/**
 * @author xiaoguo
 */
public interface ReyTaskService {

    /**
     * 添加rey任务
     * @param reyDataDTO
     * @return
     */
    ReturnResult<Object> addReyTask(TaskDataDTO reyDataDTO);

    ReyTaskDO getReyTask(Integer collectId, Integer patientId);
}
