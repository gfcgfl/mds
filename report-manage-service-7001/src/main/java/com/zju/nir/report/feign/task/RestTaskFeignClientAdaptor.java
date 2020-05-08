package com.zju.nir.report.feign.task;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiaoguo
 */
@Component("restTaskFeignClientAdaptor")
public class RestTaskFeignClientAdaptor implements FeignClientAdaptor{

    @Autowired
    private RestTaskFeignClient restTaskFeignClient;


    @Override
    public TaskDataRecord getTaskData(Integer collectId, Integer patientId) throws Exception {
        ReturnResult<TaskDataRecord> ret = restTaskFeignClient.getTaskData(collectId, patientId);
        if (ReturnResult.SUCCESS_CODE.equals(ret.getCode())) {
            return ret.getData();
        }
        throw new Exception("获取rest任务数据失败");
    }
}
