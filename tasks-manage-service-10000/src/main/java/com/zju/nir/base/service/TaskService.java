package com.zju.nir.base.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;

/**
 * @author xiaoguo
 */
public interface TaskService {

    /**
     * 添加任务
     * @param taskDataDTO
     * @return
     */
    ReturnResult<Object> addTask(TaskDataDTO taskDataDTO);
}
