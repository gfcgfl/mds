package com.zju.nir.collect.feign;

import com.alibaba.fastjson.JSONObject;
import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import sun.misc.BASE64Encoder;

import java.io.File;

/**
 * TaskDispatcher 同步的实现类负责将请求发送到对应的任务服务
 * 每一个TaskDispatcher实现类（例如ReyTaskDispatcher） 组合了一个相应的FeignClient（例如ReyTaskDispatcher
 * 中组合了一个调用rey任务服务的feign客户端ReyTaskFeignClient，用于将请求发送出去）
 *
 *
 * 可以将TaskDispatcher和FeignClient的关系理解为
 * @author xiaoguo
 */
public interface TaskDispatcher {

    public static final String DISPATHCER_NAME_PREFIX = "dispatcher-task-";

    /**
     * 将参数代表的数据发送给指定的任务服务
     * @param file
     * @param taskDataAndMark todo 暂时先用着VO对象吧
     * @return
     */
    ReturnResult<Object> forward(File file, TaskDataAndMarkVO taskDataAndMark);


    /**
     * 将TaskDataDTO手动序列化为json
     * @param dto
     * @return
     */
    default String toJson(TaskDataDTO dto) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("taskId", dto.getTaskId());
        jsonObject.put("patientId", dto.getPatientId());
        jsonObject.put("collectId", dto.getCollectId());
        jsonObject.put("startTime", dto.getStartTime());
        jsonObject.put("endTime", dto.getEndTime());

        jsonObject.put("fileString", dto.getFileString());
        jsonObject.put("data", dto.getData());
        return jsonObject.toJSONString();
    }
}
