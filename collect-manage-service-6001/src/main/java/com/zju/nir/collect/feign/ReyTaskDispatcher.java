package com.zju.nir.collect.feign;

import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.common.constant.TaskIdConstant;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author xiaoguo
 */
@Component(TaskDispatcher.DISPATHCER_NAME_PREFIX + TaskIdConstant.REY)
public class ReyTaskDispatcher implements TaskDispatcher {

    @Autowired
    private ReyTaskFeignClient reyTaskFeignClient;

    @Override
    public ReturnResult<Object> forward(File file, TaskDataAndMarkVO taskDataAndMark) {
        TaskDataDTO dto = new TaskDataDTO();
        dto.setTaskId(taskDataAndMark.getTaskId())
                .setCollectId(taskDataAndMark.getCollectId())
                .setPatientId(taskDataAndMark.getPatientId())
                .setStartTime(taskDataAndMark.getStartTime())
                .setEndTime(taskDataAndMark.getEndTime())
                .setFile(FileUtils.toBytes(file));

        dto.setData(taskDataAndMark.getTask1());
        return reyTaskFeignClient.addReyTask(toJson(dto));
    }
}
