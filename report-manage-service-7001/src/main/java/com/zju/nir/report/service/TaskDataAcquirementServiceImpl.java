package com.zju.nir.report.service;

import com.zju.nir.common.entity.ParsedBloodoxygenFileData;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.TaskDataDetail;
import com.zju.nir.common.entity.TaskDataRecord;
import com.zju.nir.report.config.ReportConfig;
import com.zju.nir.report.entity.ReportData;
import com.zju.nir.report.entity.ReportMetaData;
import com.zju.nir.report.feign.bloodoxygen.BloodoxygenParseServiceFeignClient;
import com.zju.nir.report.feign.task.FeignClientAdaptor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class TaskDataAcquirementServiceImpl implements TaskDataAcquirementService, BeanFactoryAware {

    private static final String FEIGN_CLIENT_ADAPTOR_NAME_SUFFIX = "TaskFeignClientAdaptor";

    @Autowired
    private ReportConfig reportConfig;

    @Autowired
    private BloodoxygenParseServiceFeignClient parseServiceFeignClient;

//    @Autowired
    private List<FeignClientAdaptor> availableFeign;


    @Override
    public ReportData getReportNeededTaskData(ReportMetaData reportMetaData) {
        ReportData reportData = new ReportData();
        /**
         * 先把一些元信息记录一下
         */
        reportData.setCollectId(reportMetaData.getCollectId())
                .setPatientId(reportMetaData.getPatientId())
                .setDoctorId(reportMetaData.getDoctorId())
                .setStartTime(reportMetaData.getStartTime())
                .setEndTime(reportMetaData.getEndTime());


        // todo 后边可以利用线程池来并行获取每个任务的数据
        /**
         * 获取每个任务的具体的数据
         */
        List<TaskDataDetail> details = new ArrayList<>(availableFeign.size());
        for (FeignClientAdaptor feignClientAdaptor : availableFeign) {
            try {
                TaskDataRecord taskData
                        = feignClientAdaptor.getTaskData(reportMetaData.getCollectId(), reportMetaData.getPatientId());

                //根据血样文件路径去解析血样文件，返回解析后的数据结果 todo 可以将多个任务的攒一块发过去 todo
                ReturnResult<ParsedBloodoxygenFileData> ret
                        = parseServiceFeignClient.getParsedDataByFile(taskData.getFilePath());
                if (!ReturnResult.SUCCESS_CODE.equals(ret.getCode())) {
                    continue;
                }

                TaskDataDetail target = new TaskDataDetail();
                //将解析数据写入
                target.setChannelsData(ret.getData().getChannelsData());
                target.setMarks(ret.getData().getTaskMarks());
                //将其他元信息写入
                BeanUtils.copyProperties(taskData, target);

                details.add(target);
            } catch (Exception e) {
            }
        }
        reportData.setTaskDataDetail(details);

        return reportData;
    }






    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        List<String> reportNeededTask = reportConfig.getReportNeededTask();
        if (this.availableFeign == null) {
            this.availableFeign = new ArrayList<>(reportNeededTask.size());
        }
        for (String taskName : reportNeededTask) {
            FeignClientAdaptor bean
                    = beanFactory.getBean(taskName + FEIGN_CLIENT_ADAPTOR_NAME_SUFFIX, FeignClientAdaptor.class);

            this.availableFeign.add(bean);
        }

    }
}
