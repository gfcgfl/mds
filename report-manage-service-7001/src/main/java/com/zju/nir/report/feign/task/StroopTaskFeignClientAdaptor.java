package com.zju.nir.report.feign.task;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zju.nir.common.constant.TaskIdConstant.STROOP;

/**
 * @author xiaoguo
 */

@Component("stroopTaskFeignClientAdaptor")
public class StroopTaskFeignClientAdaptor implements FeignClientAdaptor {

//    @Autowired
//    private StroopTaskFeignClient stroopTaskFeignClient;


    @Autowired
    private TaskManageServiceFeignClient taskManageServiceFeignClient;

    @Override
    public TaskDataRecord getTaskData(Integer collectId, Integer patientId) throws Exception {
        ReturnResult<TaskDataRecord> ret = taskManageServiceFeignClient.getTaskData(STROOP, collectId, patientId);
        if (ReturnResult.SUCCESS_CODE.equals(ret.getCode())) {
            return ret.getData();
        }
        throw new Exception("获取rey任务数据失败");
    }
}
