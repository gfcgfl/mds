package com.zju.nir.collect.feign;

/**
 * @author xiaoguo
 */

import com.zju.nir.common.constant.TaskServiceNameConstant;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//
//@Component
//@FeignClient(value = TaskServiceNameConstant.LINKING)
public interface LinkingTaskFeignClient {

    @PostMapping("/task/linking")
    ReturnResult<Object> addLinkingTask(@RequestParam("dataJson") String dataJson);
}
