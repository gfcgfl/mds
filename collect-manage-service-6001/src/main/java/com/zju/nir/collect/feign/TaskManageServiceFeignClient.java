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
@FeignClient(TaskServiceNameConstant.ALL_IN_ONE)
public interface TaskManageServiceFeignClient {

    @PostMapping("/task/linking")
    ReturnResult<Object> addLinkingTask(@RequestParam("dataJson") String dataJson);

    @PostMapping("/task/rest")
    ReturnResult<Object> addRestTask(@RequestParam("dataJson") String dataJson);

    @PostMapping("/task/rey")
    ReturnResult<Object> addReyTask(@RequestParam("dataJson") String dataJson);

    @PostMapping("/task/stroop")
    ReturnResult<Object> addStroopTask(@RequestParam("dataJson") String dataJson);
}
