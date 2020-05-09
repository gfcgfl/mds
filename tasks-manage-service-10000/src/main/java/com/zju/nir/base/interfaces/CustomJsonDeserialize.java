package com.zju.nir.base.interfaces;


import com.alibaba.fastjson.JSONObject;
import com.zju.nir.common.entity.TaskDataDTO;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 *
 * @author xiaoguo
 */
public interface CustomJsonDeserialize {

    /**
     * 将json反序列化为TaskDataDTO 并将其中的data字段设定为传入的dataClass类型实例
     * @param json
     * @param dataClass
     * @param <T>
     * @return
     */
    default <T> TaskDataDTO parseJson(String json, Class<T> dataClass) {

        JSONObject jsonObject = JSONObject.parseObject(json);

        String encodedData = jsonObject.getString("data");
        BASE64Decoder base64Decoder = new BASE64Decoder();
        TaskDataDTO taskDataDTO = new TaskDataDTO();
        taskDataDTO.setTaskId(jsonObject.getInteger("taskId"))
                .setPatientId(jsonObject.getInteger("patientId"))
                .setCollectId(jsonObject.getInteger("collectId"))
                .setStartTime(jsonObject.getString("startTime"))
                .setEndTime(jsonObject.getString("endTime"))
                .setFileString(jsonObject.getString("fileString"));
        JSONObject data = jsonObject.getJSONObject("data");
        T t = data.toJavaObject(dataClass);
        taskDataDTO.setData(t);
//        try {
//            byte[] bytes = base64Decoder.decodeBuffer(encodedData);
//            taskDataDTO.setFile(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return taskDataDTO;
    }

}
