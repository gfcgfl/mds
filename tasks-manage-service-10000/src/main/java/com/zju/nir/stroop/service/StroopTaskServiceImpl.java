package com.zju.nir.stroop.service;

import com.zju.nir.base.service.AbstractTaskService;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.StroopTask;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.DateUtils;
import com.zju.nir.stroop.entity.StroopTaskDO;
import com.zju.nir.stroop.entity.StroopTaskDOExample;
import com.zju.nir.stroop.mapper.StroopTaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoguo
 */
@Service
public class StroopTaskServiceImpl extends AbstractTaskService implements StroopTaskService {


    @Autowired
    private StroopTaskMapper stroopTaskMapper;


    @Override
    public ReturnResult<Object> addStroopTask(TaskDataDTO stroopDataDTO) {

        return addTask(stroopDataDTO);
    }

    @Override
    public StroopTaskDO getStroopTask(Integer collectId, Integer patientId) {
        StroopTaskDOExample example = new StroopTaskDOExample();
        StroopTaskDOExample.Criteria criteria = example.createCriteria();
        criteria.andCollectIdEqualTo(collectId);
        return stroopTaskMapper.selectByExample(example).get(0);
    }





    @Override
    protected void storeTask(String fileSaveUrl, TaskDataDTO taskDataDTO) {
        StroopTaskDO reyTaskDO = new StroopTaskDO();
        reyTaskDO.setBloodoxygenFilePath(fileSaveUrl);

        StroopTask stroopTaskSource = (StroopTask)taskDataDTO.getData();
        BeanUtils.copyProperties(stroopTaskSource, reyTaskDO);

        reyTaskDO.setStartTime(DateUtils.dateStringToDate(taskDataDTO.getStartTime()));
        reyTaskDO.setEndTime(DateUtils.dateStringToDate(taskDataDTO.getEndTime()));

        reyTaskDO.setPatientId(taskDataDTO.getPatientId());
        reyTaskDO.setCollectId(taskDataDTO.getCollectId());

        stroopTaskMapper.insert(reyTaskDO);
    }


//    private void copyProperty(Object source, StroopTaskDO stroopTaskDO) {
//        if (source instanceof Map) {
//            Map map = (Map) source;
//
//            stroopTaskDO.setAStroopMis((Integer) map.get("aStroopMis"));
//            stroopTaskDO.setAStroopTime((Integer) map.get("aStroopTime"));
//            stroopTaskDO.setBStroopMis((Integer) map.get("bStroopMis"));
//            stroopTaskDO.setBStroopTime((Integer) map.get("bStroopTime"));
//            stroopTaskDO.setCStroopMis((Integer) map.get("cStroopMis"));
//            stroopTaskDO.setCStroopTime((Integer) map.get("cStroopTime"));
//            stroopTaskDO.setDStroopMis((Integer) map.get("dStroopMis"));
//            stroopTaskDO.setDStroopTime((Integer) map.get("dStroopTime"));
//        }
//    }
}
