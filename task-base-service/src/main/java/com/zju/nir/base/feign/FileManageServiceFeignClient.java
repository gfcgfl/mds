package com.zju.nir.base.feign;

import com.zju.nir.common.constant.FileManageServiceConstant;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskBloodoxygenFileSaveDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author xiaoguo
 */
@Component
@FeignClient(value = FileManageServiceConstant.FILE_MANAGE_SERVICE_NAME)
public interface FileManageServiceFeignClient {

    @PostMapping("/file/task}")
    ReturnResult<String> saveTaskBloodoxygenFile(TaskBloodoxygenFileSaveDTO dto);

}
