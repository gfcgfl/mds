package com.zju.nir.report.feign.task;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zju.nir.common.constant.TaskIdConstant.LINKING;

/**
 * @author xiaoguo
 */

@Component("linkingTaskFeignClientAdaptor")
public class LinkingTaskFeignClientAdaptor implements FeignClientAdaptor {

//    @Autowired
//    private LinkingTaskFeignClient linkingTaskFeignClient;

    @Autowired
    private TaskManageServiceFeignClient taskManageServiceFeignClient;

    @Override
    public TaskDataRecord getTaskData(Integer collectId, Integer patientId) throws Exception {
        ReturnResult<TaskDataRecord> ret = taskManageServiceFeignClient.getTaskData(LINKING, collectId, patientId);
        if (ReturnResult.SUCCESS_CODE.equals(ret.getCode())) {
            return ret.getData();
        }
        throw new Exception("获取linking任务数据失败");
    }
}
