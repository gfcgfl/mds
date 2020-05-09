package com.zju.nir.report.feign.task;

/**
 * @author xiaoguo
 */

import com.zju.nir.common.constant.TaskServiceNameConstant;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@Component
//@FeignClient(value = TaskServiceNameConstant.LINKING)
public interface LinkingTaskFeignClient {

    @GetMapping("/task/linking/{collectId}/{patientId}")
    ReturnResult<TaskDataRecord> getTaskData(@PathVariable("collectId") Integer collectId,
                                             @PathVariable("patientId") Integer patientId);
}
