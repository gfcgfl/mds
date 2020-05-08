package com.zju.nir.file.controller;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskBloodoxygenFileSaveDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoguo
 */
@RestController
public class TaskBloodoxygenFileController {


    /**
     * 当前模块根据参数保存某个任务的血氧数据文件，并返回保存后的文件的访问路径
     * @param dto
     * @return
     */
    @PostMapping("/file/task}")
    public ReturnResult<String> saveTaskBloodoxygenFile(TaskBloodoxygenFileSaveDTO dto) {

        // todo
        // fileString 为文件的字节数组经过base64转换后的结果
        // 保存的文件的文件名为下面的这些参数用-连接，然后最后再加随机数 + 后缀名.txt
        /**
         * private Integer taskId;
         *     private Integer patientId;
         *     private Integer collectId;
         *     private String startTime;
         *     private String endTime;
         */
        //这里先模拟一下保存成功的情况
        return new ReturnResult<>(
                ReturnResult.SUCCESS_CODE,
                "保存成功",
                dto.getTaskId() + "-" + dto.getPatientId() + "-" + dto.getCollectId() + "-" + dto.getStartTime() +
                        "-" + dto.getEndTime() + "-" + System.currentTimeMillis() + ".txt"
        );

    }

}
