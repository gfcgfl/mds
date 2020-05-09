package com.zju.nir.collect.feign;

import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.common.constant.TaskIdConstant;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.File;

/**
 * @author xiaoguo
 */
@Component(TaskDispatcher.DISPATHCER_NAME_PREFIX + TaskIdConstant.REST)
public class RestTaskDispatcher implements TaskDispatcher {

//    @Autowired
//    private RestTaskFeignClient restTaskFeignClient;

    @Autowired
    private TaskManageServiceFeignClient taskManageServiceFeignClient;

    @Override
    public ReturnResult<Object> forward(File file, TaskDataAndMarkVO taskDataAndMark) {
        TaskDataDTO dto = new TaskDataDTO();
        dto.setTaskId(taskDataAndMark.getTaskId())
                .setCollectId(taskDataAndMark.getCollectId())
                .setPatientId(taskDataAndMark.getPatientId())
                .setStartTime(taskDataAndMark.getStartTime())
                .setEndTime(taskDataAndMark.getEndTime());
        BASE64Encoder encoder = new BASE64Encoder();
        String encodeBytes = encoder.encode(FileUtils.toBytes(file));
        dto.setFileString(encodeBytes);

        dto.setData(taskDataAndMark.getTask4());
        return taskManageServiceFeignClient.addRestTask(toJson(dto));
    }
}
