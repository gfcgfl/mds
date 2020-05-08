package com.zju.nir.collect.controller;

import com.alibaba.fastjson.JSONObject;
import com.zju.nir.collect.entity.xdo.CollectRecordDO;
import com.zju.nir.collect.entity.vo.CollectVO;
import com.zju.nir.collect.service.CollectManageService;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@RestController
public class CollectManageController {

    /**
     * 存放可支持的日期格式
     */
    private static final List<String> DATE_FORMAT_LIST = new ArrayList<String>(){
        {
            add("yyyy-MM-dd HH:mm:ss");
        }
    };


    @Autowired
    private CollectManageService collectManageService;




    @PostMapping("/collect/new")
    public ReturnResult<Integer> newRoundCollect(@RequestBody CollectVO collectVO) {
        //进行一些检查
        if (collectVO.getPatientId() == null || collectVO.getStartTime() == null) {
            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE, "新建采集失败，检查patientId" +
                    "和开始时间是否指定" ,null);
        }
        CollectRecordDO collect = new CollectRecordDO();

        boolean ok = false;
        Date parsedDate = null;
        try {
            for (String format : DATE_FORMAT_LIST) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                parsedDate = dateFormat.parse(collectVO.getStartTime());
                ok = true;
            }
        } catch (ParseException e) {}
        if (!ok || parsedDate == null) {
            return new ReturnResult<>(ReturnResult.LOGIC_ERROR_CODE, "日期格式不正确" ,null);
        }
        collect.setStartTime(parsedDate);
        collect.setDoctorId(collectVO.getDoctorId());
        collect.setPatientId(collectVO.getPatientId());
        return collectManageService.startNewCollectRound(collect);
    }

    /**
     * 获取 patientId患者 尚未生成报告的 采集轮次信息
     * @param createdCollectIds 当前患者已经生成报告的采集轮次id (list序列化后的json字符串)
     * @return
     */
    @GetMapping("/collect/report/not")
    public ReturnResult<List<CollectRecordDO>> getCollectRoundsNotCreateReport(Integer patientId,
                                                                         String createdCollectIds) {

        List<Integer> createdCollectIdList = JSONObject.parseArray(createdCollectIds, Integer.class);
        List<CollectRecordDO> notCreate;
        try {

            notCreate = collectManageService.listCollectRoundsNotCreateReport(patientId, createdCollectIdList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.DB_ERROR_CODE, "查找失败", Collections.emptyList());
        }

        return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "成功", notCreate);
    }

}
