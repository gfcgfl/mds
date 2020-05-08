package com.zju.nir.collect.service;

import com.zju.nir.collect.entity.xdo.CollectRecordDO;
import com.zju.nir.collect.entity.xdo.CollectRecordDOExample;
import com.zju.nir.collect.mapper.CollectRecordMapper;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class CollectManageServiceImpl implements CollectManageService {

    @Autowired
    private CollectRecordMapper collectRecordMapper;


    @Override
    public ReturnResult<Integer> startNewCollectRound(CollectRecordDO record) {
        record.setCreateTime(new Date());
        ReturnResult<Integer> ret = new ReturnResult<>();
        int id;
        try {
            id = collectRecordMapper.insert(record);
        } catch (Exception e) {
            ret.setCode(ReturnResult.DB_ERROR_CODE);
            ret.setMsg("创建新的采集失败！");
            return ret;
        }
        ret.setMsg("新的collect创建成功， id = " + id);
        ret.setCode(ReturnResult.SUCCESS_CODE);
        ret.setData(id);
        return ret;
    }

    @Override
    public ReturnResult stopCollectRound(Integer collectId, Date stopTime) {

        ReturnResult ret = new ReturnResult();

        CollectRecordDO update = new CollectRecordDO().setId(collectId)
                .setEndTime(stopTime);

        try {
            collectRecordMapper.updateByPrimaryKeySelective(update);
        } catch (Exception e) {
            ret.setCode(ReturnResult.DB_ERROR_CODE);
            ret.setMsg("结束采集失败 id = " + collectId);
            return ret;
        }

        ret.setCode(ReturnResult.SUCCESS_CODE);
        ret.setMsg("结束id为" + collectId + "的采集成功");
        return ret;
    }


//    @Override
//    public List<CollectRecordDO> listCollectRoundsNotCreateReport(Integer patientId,
//                                                                  List<Integer> createdCollectIds)
//            throws Exception{
//
//        CollectRecordDOExample example = new CollectRecordDOExample();
//        CollectRecordDOExample.Criteria criteria = example.createCriteria();
//        criteria.andPatientIdEqualTo(patientId).andIdNotIn(createdCollectIds);
//        return collectRecordMapper.selectByExample(example);
//    }
}
