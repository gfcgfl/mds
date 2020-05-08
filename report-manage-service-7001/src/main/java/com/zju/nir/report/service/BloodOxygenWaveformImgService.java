package com.zju.nir.report.service;

import com.zju.nir.common.entity.TaskDataDetail;

import java.io.File;
import java.util.List;

/**
 * @author xiaoguo
 */
public interface BloodOxygenWaveformImgService {


    /**
     * 创建一个任务的所有波形图
     * @param taskDataDetail
     * @return
     */
    List<File> createOneTaskImgFile(TaskDataDetail taskDataDetail);
}
