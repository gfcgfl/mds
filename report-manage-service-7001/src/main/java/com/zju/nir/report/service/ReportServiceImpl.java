package com.zju.nir.report.service;

import com.zju.nir.common.entity.ReportFileSaveDTO;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.utils.FileUtils;
import com.zju.nir.report.entity.*;
import com.zju.nir.report.feign.file.FileManageServiceFeignClient;
import com.zju.nir.report.mapper.ReportRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRecordMapper reportRecordMapper;

    @Autowired
    private TaskDataAcquirementService taskDataAcquirementService;

    @Autowired
    private ReportCreateService reportCreateService;

    @Autowired
    private FileManageServiceFeignClient fileManageServiceFeignClient;


    @Override
    public List<ReportRecordDO> listCreatedReportsByPatientId(Integer patientId) {
        ReportRecordDOExample e = new ReportRecordDOExample();
        ReportRecordDOExample.Criteria criteria = e.createCriteria();
        criteria.andPatientIdEqualTo(patientId);
        return reportRecordMapper.selectByExample(e);
    }


    @Override
    public List<ReportCreationStatus> listReportCreationStatusByPatientId(Integer patientId) throws Exception {
        return reportRecordMapper.listReportCreationStatusByPatientId(patientId);
    }


    @Override
    public ReportMessage createReport(ReportMetaData reportMetaData) {
        /**
         * 获取到报告所需的任务数据
         */
        ReportData reportData = taskDataAcquirementService.getReportNeededTaskData(reportMetaData);

        /**
         * 生成报告
         */
        File tempFile;
        try {
            tempFile = reportCreateService.createPdfReport(reportData);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReportMessage().setCreated(false);
        }

        /**
         * 将生成的报告进行存储（交由file-manage-service模块）
         */
        ReportStorageStatus storageStatus = this.storeReportFile(tempFile, reportMetaData);
        FileUtils.deleteFile(tempFile);


        /**
         * 将报告记录添加到数据库
         */
        addReportRecord(storageStatus, reportMetaData);

        if (!storageStatus.getSucceed()) {
            return new ReportMessage().setCreated(false);
        }

        /**
         * 获取报告文件可访问的路径
         */
        String accessPath = this.getReportAccessPath(storageStatus);


        /**
         * 封装ReportMessage信息返回
         */
        ReportMessage reportMessage = new ReportMessage();
        reportMessage.setCreated(true)
                .setRedirectPath(accessPath)
                .setStorageStatus(storageStatus);

        return reportMessage;
    }

    private void addReportRecord(ReportStorageStatus storageStatus,
                                 ReportMetaData reportMetaData) {

        reportRecordMapper.insert(
                new ReportRecordDO()
                        .setPatientId(reportMetaData.getPatientId())
                        .setCollectId(reportMetaData.getCollectId())
                        .setCreatTime(new Date())
                        .setStatus(storageStatus.getSucceed() ? 1 : 0)
                        .setReportPath(storageStatus.getPath())
        );

    }


    /**
     * 获取到报告可访问路径 （后续可以通过重定向方式访问到）
     *
     * @param reportStorageStatus
     * @return
     */
    private String getReportAccessPath(ReportStorageStatus reportStorageStatus) {
        return reportStorageStatus.getPath();
    }


    /**
     * 调用其他模块，将文件存储起来  todo
     *
     * @param reportFile
     * @param reportMetaData
     * @return
     */
    private ReportStorageStatus storeReportFile(File reportFile, ReportMetaData reportMetaData) {
        ReportFileSaveDTO reportFileSaveDTO = new ReportFileSaveDTO()
                .setCollectId(reportMetaData.getCollectId())
                .setDoctorId(reportMetaData.getDoctorId())
                .setPatientId(reportMetaData.getPatientId())
                .setCollectStartTime(reportMetaData.getStartTime())
                .setCollectEndTime(reportMetaData.getEndTime())
                .setFileBytes(FileUtils.toBytes(reportFile));

        ReturnResult<String> ret =
                fileManageServiceFeignClient.saveReportFile(reportFileSaveDTO);
        if (!ReturnResult.SUCCESS_CODE.equals(ret.getCode())) {
            return new ReportStorageStatus().setSucceed(false);
        }
        return new ReportStorageStatus().setSucceed(true).setPath(ret.getData());
    }
}
