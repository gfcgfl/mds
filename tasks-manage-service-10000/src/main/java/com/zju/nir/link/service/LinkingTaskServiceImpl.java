package com.zju.nir.link.service;

import com.zju.nir.base.feign.FileManageServiceFeignClient;
import com.zju.nir.base.service.AbstractTaskService;
import com.zju.nir.common.entity.LinkingTask;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDTO;
import com.zju.nir.common.utils.DateUtils;
import com.zju.nir.common.utils.FileUtils;
import com.zju.nir.link.entity.LinkingTaskDO;
import com.zju.nir.link.entity.LinkingTaskDOExample;
import com.zju.nir.link.mapper.LinkingTaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author xiaoguo
 */
@Service
public class LinkingTaskServiceImpl extends AbstractTaskService implements LinkingTaskService {

    @Autowired
    private LinkingTaskMapper linkingTaskMapper;




    @Override
    public ReturnResult<Object> addLinkingTask(TaskDataDTO linkingDataDTO) {
        return addTask(linkingDataDTO);
    }



    @Override
    public LinkingTaskDO getLinkingTask(Integer collectId, Integer patientId) {

        LinkingTaskDOExample example = new LinkingTaskDOExample();
        LinkingTaskDOExample.Criteria criteria = example.createCriteria();
        criteria.andCollectIdEqualTo(collectId);
        return linkingTaskMapper.selectByExample(example).get(0);
    }


//    @Override
//    protected String storeFile(TaskDataDTO taskDataDTO) {
//        File tempFile = FileUtils.parseToFile(taskDataDTO.getFile());
////        if (tempFile == null) {
////            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE,
////                    "提交任务" + taskDataDTO.getTaskId() + "失败，",
////                    null);
////        }
//        fileManageServiceFeignClient.saveTaskBloodoxygenFile()
//        tempFile.deleteOnExit();
//
//    }

    @Override
    protected void storeTask(String fileSaveUrl, TaskDataDTO taskDataDTO) {
        LinkingTaskDO linkingTaskDO = new LinkingTaskDO();
        linkingTaskDO.setBloodoxygenFilePath(fileSaveUrl);

        LinkingTask linkingTaskSource = (LinkingTask)taskDataDTO.getData();
        BeanUtils.copyProperties(linkingTaskSource, linkingTaskDO);

        linkingTaskDO.setStartTime(DateUtils.dateStringToDate(taskDataDTO.getStartTime()))
                .setEndTime(DateUtils.dateStringToDate(taskDataDTO.getEndTime()))
                .setPatientId(taskDataDTO.getPatientId())
                .setCollectId(taskDataDTO.getCollectId());

        linkingTaskMapper.insert(linkingTaskDO);
    }

//    private void copyProperty(Object source, LinkingTaskDO linkingTaskDO) {
//        if (source instanceof Map) {
//            Map map = (Map) source;
//
//            linkingTaskDO.setAWordMis((Integer) map.get("awordMis"));
//            linkingTaskDO.setAWordTime((Integer) map.get("awordTime"));
//            linkingTaskDO.setBWordMis((Integer) map.get("bwordMis"));
//            linkingTaskDO.setBWordTime((Integer) map.get("bwordTime"));
//        }
//    }
}
