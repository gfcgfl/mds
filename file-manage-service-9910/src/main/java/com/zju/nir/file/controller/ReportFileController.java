package com.zju.nir.file.controller;

import com.zju.nir.common.entity.ReportFileSaveDTO;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoguo
 */
@RestController
public class ReportFileController {

    /**
     * 保存报告文件，返回的参数为保存的路径
     * @param reportFileSaveDTO
     * @return
     */
    @PostMapping("/file/report")
    public ReturnResult<String> saveReportFile(@RequestBody ReportFileSaveDTO reportFileSaveDTO) {
        // todo
        // fileString 为文件的字节数组经过base64转换后的结果
        // 保存的文件的文件名为下面的这些参数用-连接，然后最后再加随机数 + 后缀名.pdf
        /**
         * private Integer collectId;
         *
         *     private Integer patientId;
         *
         *
         *    private Date collectStartTime;
         *
         *    private Date collectEndTime;
         */

        //这里先模拟一下保存成功的情况
        return new ReturnResult<>(
                ReturnResult.SUCCESS_CODE,
                "保存成功",
                reportFileSaveDTO.getPatientId() + "-"
                        + reportFileSaveDTO.getCollectId() + "-" + reportFileSaveDTO.getCollectStartTime() +
                        "-" + reportFileSaveDTO.getCollectEndTime() + "-" + System.currentTimeMillis() + ".pdf"
        );
    }
}
