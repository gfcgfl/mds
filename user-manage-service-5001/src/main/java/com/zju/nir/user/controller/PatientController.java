package com.zju.nir.user.controller;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.utils.JsonUtils;
import com.zju.nir.user.entity.PatientDO;
import com.zju.nir.user.entity.PatientInfoVO;
import com.zju.nir.user.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author xiaoguo
 */
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/{patientId}")
    public ReturnResult<String> getPatientInfoById(@PathVariable("patientId") int patientId) {

        PatientDO patientDO = patientService.selectPatientById(patientId);

        if (patientDO == null) {
            return new ReturnResult<>(
                    ReturnResult.SUCCESS_CODE,
                    "患者不存在",
                    null
            );
        }
        Integer type = patientService.selectPatientAdhdTypeById(patientId);

        type = 1;

        PatientInfoVO patientInfo = new PatientInfoVO();
        patientInfo.setId(patientDO.getId().toString())
                .setName(patientDO.getName())
                .setGender(patientDO.getGender().toString())
                .setAge(patientDO.getAge().toString())
                .setWeight(patientDO.getWeight())
                .setHeight(patientDO.getHeight())
                .setAdhdType(type.toString())
                .setExists("true");

        return new ReturnResult<>(
                ReturnResult.SUCCESS_CODE,
                "查找成功",
                JsonUtils.jsonFromObject(patientInfo)
        );

    }

    @PostMapping("/patient/upsert")
    public ReturnResult<Object> upsertPatient(@RequestBody PatientInfoVO patientInfoVO) {
        Boolean exists = Boolean.valueOf(patientInfoVO.getExists());
        PatientDO patientDO = new PatientDO();
        patientDO.setId(Integer.valueOf(patientInfoVO.getId()))
                .setName(patientInfoVO.getName())
                .setHeight(patientInfoVO.getHeight())
                .setWeight(patientInfoVO.getWeight())
                .setAge(Integer.valueOf(patientInfoVO.getAge()))
                .setGender(Integer.valueOf(patientInfoVO.getGender()));
        Date date = new Date();

        try {
            if (Boolean.TRUE.equals(exists)) {
                patientDO.setUpdateTime(date);
                patientService.updatePatient(patientDO);
            } else {
                patientDO.setCreateTime(date).setUpdateTime(date);
                patientService.insertPatient(patientDO);
            }

            // 添加干预信息 以及添加adhd类型 （这两项永远都是新增，不在原来的基础上修改）
            patientService.addIntervene();
            patientService.addAdhdTypeRecord(Integer.valueOf(patientInfoVO.getId()), Integer.valueOf(patientInfoVO.getAdhdType()));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult<>(ReturnResult.DB_ERROR_CODE, "失败", null);
        }
        return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "成功", null);
    }


}
