package com.zju.nir.rest.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.rest.entity.RestTaskDO;

/**
 * @author xiaoguo
 */
public interface RestTaskService {

    /**
     * 添加rest任务
     * @param restDataDTO
     * @return
     */
    ReturnResult<Object> addRestTask(TaskDataDTO restDataDTO);

    RestTaskDO getRestTask(Integer collectId, Integer patientId);
}
