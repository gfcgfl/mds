package com.zju.nir.collect.service;

import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.collect.feign.TaskDispatcher;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author xiaoguo
 */
@Service
public class DispatchTaskServiceImpl implements DispatchTaskService, BeanFactoryAware {

    private BeanFactory beanFactory;


    @Override
    public ReturnResult<Object> dispatch(File markedFile, TaskDataAndMarkVO taskDataAndMark) {
        int taskId = taskDataAndMark.getTaskId();
        //根据id找到对应的Dispatcher
        TaskDispatcher dispatcher = getDispatcher(taskId);

        return dispatcher.forward(markedFile, taskDataAndMark);
    }


    private TaskDispatcher getDispatcher(int taskId) {
        return (TaskDispatcher)this.beanFactory.getBean(TaskDispatcher.DISPATHCER_NAME_PREFIX + taskId);
    }





    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
