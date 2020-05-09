package com.zju.nir.rey.service;

import com.zju.nir.base.service.AbstractTaskService;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.ReyTask;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.DateUtils;
import com.zju.nir.rey.entity.ReyTaskDO;
import com.zju.nir.rey.entity.ReyTaskDOExample;
import com.zju.nir.rey.mapper.ReyTaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoguo
 */
@Service
public class ReyTaskServiceImpl extends AbstractTaskService implements ReyTaskService {


    @Autowired
    private ReyTaskMapper reyTaskMapper;


    @Override
    public ReturnResult<Object> addReyTask(TaskDataDTO reyDataDTO) {

        return addTask(reyDataDTO);
    }

    @Override
    public ReyTaskDO getReyTask(Integer collectId, Integer patientId) {
        ReyTaskDOExample example = new ReyTaskDOExample();
        ReyTaskDOExample.Criteria criteria = example.createCriteria();
        criteria.andCollectIdEqualTo(collectId);
        return reyTaskMapper.selectByExample(example).get(0);
    }


//    @Override
//    protected String storeFile(TaskDataDTO file) {
//
//        file.deleteOnExit();
//        return "/test/temp";
//    }



    @Override
    protected void storeTask(String fileSaveUrl, TaskDataDTO taskDataDTO) {
        ReyTaskDO reyTaskDO = new ReyTaskDO();
        reyTaskDO.setBloodoxygenFilePath(fileSaveUrl);

        ReyTask reyTaskSource = (ReyTask)taskDataDTO.getData();
        BeanUtils.copyProperties(reyTaskSource, reyTaskDO);

        reyTaskDO.setStartTime(DateUtils.dateStringToDate(taskDataDTO.getStartTime()));
        reyTaskDO.setEndTime(DateUtils.dateStringToDate(taskDataDTO.getEndTime()));

        reyTaskDO.setPatientId(taskDataDTO.getPatientId());
        reyTaskDO.setCollectId(taskDataDTO.getCollectId());

        reyTaskMapper.insert(reyTaskDO);
    }

//    private void copyProperty(Object source, ReyTaskDO reyTaskDO) {
//        if (source instanceof Map) {
//            Map map = (Map) source;
//
//            reyTaskDO.setReySiScore((Integer) map.get("reySiScore"));
//            reyTaskDO.setReyDiScore((Integer) map.get("reyDiScore"));
//            reyTaskDO.setReySdScore((Integer) map.get("reySdScore"));
//            reyTaskDO.setReyDdScore((Integer) map.get("reyDdScore"));
//        }
//    }
}
