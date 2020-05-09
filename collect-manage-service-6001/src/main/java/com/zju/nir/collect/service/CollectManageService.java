package com.zju.nir.collect.service;

import com.zju.nir.collect.entity.xdo.CollectRecordDO;
import com.zju.nir.common.entity.ReturnResult;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
public interface CollectManageService {

    /**
     * 开启新的一次采集
     * @param record
     * @return 返回这次采集的id
     */
    ReturnResult<Integer> startNewCollectRound(CollectRecordDO record);


    /**
     * 结束某次采集
     * @param collectId
     * @param stopTime
     * @return
     */
    ReturnResult stopCollectRound(Integer collectId, Date stopTime);


    /**
     * 获取 patientId患者 尚未生成报告的 采集轮次信息
     * @param patientId
     * @param createdCollectIds 当前患者已经生成报告的采集轮次id
     * @return
     */
    List<CollectRecordDO> listCollectRoundsNotCreateReport(Integer patientId,
                                                           List<Integer> createdCollectIds) throws Exception;

}
