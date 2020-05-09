package com.zju.nir.rest.controller;

import com.zju.nir.base.interfaces.CustomJsonDeserialize;
import com.zju.nir.common.entity.RestTask;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.entity.TaskDataRecordVO;
import com.zju.nir.rest.entity.RestTaskDO;
import com.zju.nir.rest.service.RestTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

import static com.zju.nir.common.constant.TaskFullNameConstant.REST_FULLNAME;
import static com.zju.nir.common.constant.TaskIdConstant.REST;

/**
 * @author xiaoguo
 */
@RestController
public class RestTaskController implements CustomJsonDeserialize {

    @Autowired
    private RestTaskService restTaskService;

    /**
     * @param dataJson 对应的实体为 {@link TaskDataDTO}
     * @return
     */
    @PostMapping("/task/rest")
    public ReturnResult<Object> addRestTask(String dataJson) {

        TaskDataDTO taskDataDTO = parseJson(dataJson, RestTask.class);
        if (!check(taskDataDTO)) {
            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE,
                    "上传rest任务数据失败，验证未通过",
                    null);
        }

        return restTaskService.addRestTask(taskDataDTO);

    }

    @GetMapping("/task/" + REST + "/{collectId}/{patientId}")
    public ReturnResult<TaskDataRecordVO> getTaskData(@PathVariable("collectId") Integer collectId,
                                                      @PathVariable("patientId") Integer patientId) {

        try {
            RestTaskDO restTaskDO = restTaskService.getRestTask(collectId, patientId);
            TaskDataRecordVO vo = new TaskDataRecordVO();
            vo.setTaskId(REST)
                    .setTaskName("任务" + REST + ": " + REST_FULLNAME)
                    .setFilePath(restTaskDO.getBloodoxygenFilePath())
                    .setStartTime(restTaskDO.getStartTime())
                    .setEndTime(restTaskDO.getEndTime());

            LinkedHashMap<String, Object> details = new LinkedHashMap<>(1, 0.75f);
            vo.setRecords(details);
            return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "获取rest任务数据成功", vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.INTERNAL_ERROR_CODE, "获取rest任务数据失败", null);
        }


    }


    private boolean check(TaskDataDTO taskDataDTO) {

        if (taskDataDTO == null
                || taskDataDTO.getTaskId() != REST
                || taskDataDTO.getCollectId() == null
                || taskDataDTO.getPatientId() == null) {
            return false;
        }
        return true;
    }

}
