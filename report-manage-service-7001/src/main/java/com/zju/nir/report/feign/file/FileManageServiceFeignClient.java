package com.zju.nir.report.feign.file;

import com.zju.nir.common.entity.ReportFileSaveDTO;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.zju.nir.common.constant.FileManageServiceConstant.FILE_MANAGE_SERVICE_NAME;

/**
 * @author xiaoguo
 */
@Component
@FeignClient(value = FILE_MANAGE_SERVICE_NAME)
public interface FileManageServiceFeignClient {

    /**
     * 保存报告文件，返回的参数为保存的路径
     * @param reportFileSaveDTO
     * @return
     */
    @PostMapping("/file/report")
    ReturnResult<String> saveReportFile(@RequestBody ReportFileSaveDTO reportFileSaveDTO);

}
