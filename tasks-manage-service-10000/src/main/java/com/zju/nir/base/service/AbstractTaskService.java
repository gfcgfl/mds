package com.zju.nir.base.service;

import com.zju.nir.base.feign.FileManageServiceFeignClient;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskBloodoxygenFileSaveDTO;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.FileUtils;
import org.aspectj.apache.bcel.generic.RET;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @author xiaoguo
 */
public abstract class AbstractTaskService implements TaskService {


    @Autowired
    protected FileManageServiceFeignClient fileManageServiceFeignClient;



    @Override
    public ReturnResult<Object> addTask(TaskDataDTO taskDataDTO) {

        boolean flag = true;

        try {
            //将文件保存起来
            String fileSaveUrl = storeBloodoxygenFile(taskDataDTO);


            // 任务数据存库
            if (fileSaveUrl != null) {
                storeTask(fileSaveUrl, taskDataDTO);
            } else {
                flag = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        ReturnResult<Object> ret;
        if (flag) {
            ret = new ReturnResult<>(ReturnResult.SUCCESS_CODE,
                    "提交任务" + taskDataDTO.getTaskId() + "成功",
                    null);
        } else {
            ret = new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE,
                    "提交任务" + taskDataDTO.getTaskId() + "失败",
                    null);
        }
        return ret;
    }


    /**
     * 将文件存储
     *
     * @param taskDataDTO
     * @return
     */
    private String storeBloodoxygenFile(TaskDataDTO taskDataDTO) {

        TaskBloodoxygenFileSaveDTO dto = new TaskBloodoxygenFileSaveDTO()
                .setCollectId(taskDataDTO.getCollectId())
                .setPatientId(taskDataDTO.getPatientId())
                .setTaskId(taskDataDTO.getTaskId())
                .setStartTime(taskDataDTO.getStartTime())
                .setEndTime(taskDataDTO.getEndTime())
                .setFileString(taskDataDTO.getFileString());
        ReturnResult<String> ret = fileManageServiceFeignClient.saveTaskBloodoxygenFile(dto);
        return ReturnResult.SUCCESS_CODE.equals(ret.getCode())
                ? ret.getData() : null;

    }

    /**
     * 任务数据存库
     *
     * @param fileSaveUrl
     * @param taskDataDTO
     */
    protected abstract void storeTask(String fileSaveUrl, TaskDataDTO taskDataDTO);

}
