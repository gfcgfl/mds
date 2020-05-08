package com.zju.nir.collect.service;

import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.common.entity.ReturnResult;

import java.io.File;

/**
 * 负责将任务数据转发给具体的任务模块
 * @author xiaoguo
 */
public interface DispatchTaskService {

    ReturnResult<Object> dispatch(File markedFile, TaskDataAndMarkVO taskDataAndMark);



}
