package com.zju.nir.report.feign.task;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiaoguo
 */

@Component("linkingTaskFeignClientAdaptor")
public class LinkingTaskFeignClientAdaptor implements FeignClientAdaptor{

    @Autowired
    private LinkingTaskFeignClient linkingTaskFeignClient;

    @Override
    public TaskDataRecord getTaskData(Integer collectId, Integer patientId) throws Exception {
        ReturnResult<TaskDataRecord> ret = linkingTaskFeignClient.getTaskData(collectId, patientId);
        if (ReturnResult.SUCCESS_CODE.equals(ret.getCode())) {
            return ret.getData();
        }
        throw new Exception("获取linking任务数据失败");
    }
}
