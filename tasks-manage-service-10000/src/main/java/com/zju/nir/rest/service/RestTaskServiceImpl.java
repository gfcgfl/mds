package com.zju.nir.rest.service;

import com.zju.nir.base.service.AbstractTaskService;
import com.zju.nir.common.entity.RestTask;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.DateUtils;
import com.zju.nir.rest.entity.RestTaskDO;
import com.zju.nir.rest.entity.RestTaskDOExample;
import com.zju.nir.rest.mapper.RestTaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoguo
 */
@Service
public class RestTaskServiceImpl extends AbstractTaskService implements RestTaskService {


    @Autowired
    private RestTaskMapper restTaskMapper;


    @Override
    public ReturnResult<Object> addRestTask(TaskDataDTO restDataDTO) {

        return addTask(restDataDTO);
    }

    @Override
    public RestTaskDO getRestTask(Integer collectId, Integer patientId) {
        RestTaskDOExample example = new RestTaskDOExample();
        RestTaskDOExample.Criteria criteria = example.createCriteria();
        criteria.andCollectIdEqualTo(collectId);
        return restTaskMapper.selectByExample(example).get(0);
    }




    @Override
    protected void storeTask(String fileSaveUrl, TaskDataDTO taskDataDTO) {
        RestTaskDO reyTaskDO = new RestTaskDO();
        reyTaskDO.setBloodoxygenFilePath(fileSaveUrl);

        RestTask restTaskSource = (RestTask)taskDataDTO.getData();
        BeanUtils.copyProperties(restTaskSource, reyTaskDO);

        reyTaskDO.setStartTime(DateUtils.dateStringToDate(taskDataDTO.getStartTime()));
        reyTaskDO.setEndTime(DateUtils.dateStringToDate(taskDataDTO.getEndTime()));

        reyTaskDO.setPatientId(taskDataDTO.getPatientId());
        reyTaskDO.setCollectId(taskDataDTO.getCollectId());

        restTaskMapper.insert(reyTaskDO);
    }

//    private void copyProperty(Object source, RestTaskDO restTaskDO) {
////        if (source instanceof Map) {
////            Map map = (Map) source;
////
////
////        }
//    }
}
