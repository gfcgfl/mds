package com.zju.nir.stroop.controller;//package com.zju.nir.rest.controller;

import com.zju.nir.base.interfaces.CustomJsonDeserialize;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.StroopTask;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.entity.TaskDataRecordVO;
import com.zju.nir.stroop.entity.StroopTaskDO;
import com.zju.nir.stroop.service.StroopTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

import static com.zju.nir.common.constant.TaskFullNameConstant.STROOP_FULLNAME;
import static com.zju.nir.common.constant.TaskIdConstant.REY;
import static com.zju.nir.common.constant.TaskIdConstant.STROOP;

/**
 * @author xiaoguo
 */
@RestController
public class StroopTaskController implements CustomJsonDeserialize {

    @Autowired
    private StroopTaskService stroopTaskService;

    /**
     * @param dataJson 对应的实体为 {@link TaskDataDTO}
     * @return
     */
    @PostMapping("/task/stroop")
    public ReturnResult<Object> addStroopTask(String dataJson) {

        TaskDataDTO taskDataDTO = parseJson(dataJson, StroopTask.class);
        if (!check(taskDataDTO)) {
            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE,
                    "上传stroop任务数据失败，验证未通过",
                    null);
        }

        return stroopTaskService.addStroopTask(taskDataDTO);

    }

    @GetMapping("/task/" + STROOP + "/{collectId}/{patientId}")
    public ReturnResult<TaskDataRecordVO> getTaskData(@PathVariable("collectId") Integer collectId,
                                                      @PathVariable("patientId") Integer patientId) {

        try {
            StroopTaskDO stroopTaskDO = stroopTaskService.getStroopTask(collectId, patientId);
            TaskDataRecordVO vo = new TaskDataRecordVO();
            vo.setTaskId(STROOP)
                    .setTaskName("任务" + STROOP + ": " + STROOP_FULLNAME)
                    .setFilePath(stroopTaskDO.getBloodoxygenFilePath())
                    .setStartTime(stroopTaskDO.getStartTime())
                    .setEndTime(stroopTaskDO.getEndTime());

            LinkedHashMap<String, Object> details = new LinkedHashMap<>(16, 0.75f);
            details.put("aStroopMis", stroopTaskDO.getAStroopMis());
            details.put("aStroopTime", stroopTaskDO.getAStroopTime());
            details.put("bStroopMis", stroopTaskDO.getBStroopMis());
            details.put("bStroopTime", stroopTaskDO.getBStroopTime());
            details.put("cStroopMis", stroopTaskDO.getCStroopMis());
            details.put("cStroopTime", stroopTaskDO.getCStroopTime());
            details.put("dStroopMis", stroopTaskDO.getDStroopMis());
            details.put("dStroopTime", stroopTaskDO.getDStroopTime());
            vo.setRecords(details);
            return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "获取stroop任务数据成功", vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.INTERNAL_ERROR_CODE, "获取stroop任务数据失败", null);
        }


    }


    private boolean check(TaskDataDTO taskDataDTO) {

        if (taskDataDTO == null
                || taskDataDTO.getTaskId() != STROOP
                || taskDataDTO.getCollectId() == null
                || taskDataDTO.getPatientId() == null) {
            return false;
        }
        return true;
    }

}
