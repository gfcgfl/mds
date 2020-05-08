package com.zju.nir.collect.controller;

import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.collect.service.DispatchTaskService;
import com.zju.nir.collect.service.MarkService;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.zju.nir.common.constant.TaskIdConstant.*;

/**
 * 在一次采集中，上传每个任务数据信息时的入口在这里，由其再转发给具体的任务服务
 *
 * @author xiaoguo
 */
@RestController
public class TaskEntranceController {


    @Autowired
    private MarkService markService;


    @Autowired
    private DispatchTaskService dispatchTaskService;

    /**
     * @param file        血氧数据的文件
     * @param data 某个任务的得分情况以及做任务过程中所打的标记 对应着{@link TaskDataAndMarkVO}
     */
    @PostMapping("/collect/task")
    public ReturnResult<Object> addTask(@RequestParam("file") MultipartFile file, String data) {

        TaskDataAndMarkVO taskDataAndMark = JsonUtils.objectFromJson(data, TaskDataAndMarkVO.class);
        if (!check(taskDataAndMark)) {
            return new ReturnResult<>(ReturnResult.INTERNAL_ERROR_CODE,
                    "内部错误：解析传入的数据失败",
                    null);
        }


        File tempFile = null;
        try {
            tempFile = File.createTempFile(UUID.randomUUID().toString(), "add-tmp");
            file.transferTo(tempFile);
        } catch (IOException e) {
            return new ReturnResult<>(ReturnResult.INTERNAL_ERROR_CODE,
                    "内部错误：转换临时文件失败",
                    null);
        }


        File markedFile = markService.doMark(taskDataAndMark.getMarks(), tempFile);
        tempFile.deleteOnExit();

        // todo 将标记后的文件和任务数据发送给特定的任务服务
        ReturnResult<Object> ret = dispatchTaskService.dispatch(tempFile, taskDataAndMark);
        markedFile.deleteOnExit();
        return ret;
    }


    private boolean check(TaskDataAndMarkVO taskDataAndMark) {
        Integer taskId;
        if (taskDataAndMark == null
                || taskDataAndMark.getCollectId() == null
                || taskDataAndMark.getPatientId() == null
                || (taskId = taskDataAndMark.getTaskId()) == null) {
            return false;
        }

        int id = taskId;
        return ((id == REY) && taskDataAndMark.getTask1() != null)
                || ((id == LINKING) && taskDataAndMark.getTask2() != null)
                || ((id == STROOP) && taskDataAndMark.getTask3() != null)
                || ((id == REST) && taskDataAndMark.getTask4() != null)
                || ((id == SNAP) && taskDataAndMark.getTask5() != null);

    }

}
