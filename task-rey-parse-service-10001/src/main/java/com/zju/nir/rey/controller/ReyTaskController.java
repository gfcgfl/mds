package com.zju.nir.rey.controller;

import com.zju.nir.base.interfaces.CustomJsonDeserialize;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.ReyTask;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.entity.TaskDataRecordVO;
import com.zju.nir.rey.entity.ReyTaskDO;
import com.zju.nir.rey.service.ReyTaskService;
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
public class ReyTaskController implements CustomJsonDeserialize {

    @Value("${task.id}")
    private int taskId;

    @Value("${task.name}")
    private String taskName;

    @Autowired
    private ReyTaskService reyTaskService;

    /**
     * @param dataJson 对应的实体为 {@link com.zju.nir.common.entity.TaskDataDTO}
     * @return
     */
    @PostMapping("/task/rey")
    public ReturnResult<Object> addReyTask(String dataJson) {

        TaskDataDTO taskDataDTO = parseJson(dataJson, ReyTask.class);
        if (!check(taskDataDTO)) {
            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE, "上传rey任务数据失败，验证未通过", null);
        }

        return reyTaskService.addReyTask(taskDataDTO);

    }

    @GetMapping("/task/{collectId}/{patientId}")
    public ReturnResult<TaskDataRecordVO> getTaskData(@PathVariable("collectId") Integer collectId,
                                                      @PathVariable("patientId") Integer patientId) {

        try {
            ReyTaskDO reyTaskDO = reyTaskService.getReyTask(collectId, patientId);
            TaskDataRecordVO vo = new TaskDataRecordVO();
            vo.setTaskId(taskId)
                    .setTaskName("任务" + taskId + ": " + taskName)
                    .setFilePath(reyTaskDO.getBloodoxygenFilePath())
                    .setStartTime(reyTaskDO.getStartTime())
                    .setEndTime(reyTaskDO.getEndTime());

            LinkedHashMap<String, Object> details = new LinkedHashMap<>(8, 0.75f);
            details.put("reySiScore", reyTaskDO.getReySiScore());
            details.put("reyDiScore", reyTaskDO.getReyDiScore());
            details.put("reySdScore", reyTaskDO.getReySdScore());
            details.put("reyDdScore", reyTaskDO.getReyDdScore());
            vo.setRecords(details);
            return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "获取rey任务数据成功", vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.INTERNAL_ERROR_CODE, "获取rey任务数据失败", null);
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
