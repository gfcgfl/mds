package com.zju.nir.link.controller;

import com.zju.nir.base.interfaces.CustomJsonDeserialize;
import com.zju.nir.common.entity.*;
import com.zju.nir.link.entity.LinkingTaskDO;
import com.zju.nir.link.service.LinkingTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @author xiaoguo
 */
@RestController
public class LinkingTaskController implements CustomJsonDeserialize {

    @Value("${task.id}")
    private int taskId;

    @Value("${task.name}")
    private String taskName;

    @Autowired
    private LinkingTaskService linkingTaskService;

    /**
     * @param dataJson 对应的实体为 {@link TaskDataDTO}
     * @return
     */
    @PostMapping("/task/linking")
    public ReturnResult<Object> addLinkingTask(String dataJson) {

        TaskDataDTO taskDataDTO = parseJson(dataJson, LinkingTask.class);
//        TaskDataDTO taskDataDTO = JsonUtils.objectFromJson(dataJson, TaskDataDTO.class);
        if (!check(taskDataDTO)) {
            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE,
                    "上传linking任务数据失败，验证未通过",
                    null);
        }

        return linkingTaskService.addLinkingTask(taskDataDTO);
    }


    @GetMapping("/task/{collectId}/{patientId}")
    public ReturnResult<TaskDataRecordVO> getTaskData(@PathVariable("collectId") Integer collectId,
                                                      @PathVariable("patientId") Integer patientId) {

        try {
            LinkingTaskDO linkingTaskDO = linkingTaskService.getLinkingTask(collectId, patientId);
            TaskDataRecordVO vo = new TaskDataRecordVO();
            vo.setTaskId(taskId)
                    .setTaskName("任务" + taskId + ": " + taskName)
                    .setFilePath(linkingTaskDO.getBloodoxygenFilePath())
                    .setStartTime(linkingTaskDO.getStartTime())
                    .setEndTime(linkingTaskDO.getEndTime());

            LinkedHashMap<String, Object> details = new LinkedHashMap<>(8, 0.75f);
            details.put("aWordMis", linkingTaskDO.getAWordMis());
            details.put("aWordTime", linkingTaskDO.getAWordTime());
            details.put("bWordMis", linkingTaskDO.getBWordMis());
            details.put("bWordTime", linkingTaskDO.getBWordTime());
            vo.setRecords(details);
            return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "获取linking任务数据成功", vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.INTERNAL_ERROR_CODE, "获取linking任务数据失败", null);
        }


    }


    private boolean check(TaskDataDTO taskDataDTO) {

        if (taskDataDTO == null
                || taskDataDTO.getTaskId() != taskId
                || taskDataDTO.getCollectId() == null
                || taskDataDTO.getPatientId() == null) {
            return false;
        }
        return true;
    }

}
