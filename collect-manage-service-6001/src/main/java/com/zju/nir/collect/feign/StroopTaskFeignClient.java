package com.zju.nir.collect.feign;

import com.zju.nir.common.constant.TaskServiceNameConstant;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaoguo
 */
@Component
@FeignClient(value = TaskServiceNameConstant.STROOP)
public interface StroopTaskFeignClient {

    @PostMapping("/task/stroop")
    ReturnResult<Object> addStroopTask(@RequestParam("dataJson") String dataJson);
}
