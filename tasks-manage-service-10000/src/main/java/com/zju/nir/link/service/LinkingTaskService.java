package com.zju.nir.link.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.link.entity.LinkingTaskDO;

/**
 * @author xiaoguo
 */
public interface LinkingTaskService {

    /**
     * 添加linking任务
     * @param linkingDataDTO
     * @return
     */
    ReturnResult<Object> addLinkingTask(TaskDataDTO linkingDataDTO);



    LinkingTaskDO getLinkingTask(Integer collectId, Integer patientId);
}
