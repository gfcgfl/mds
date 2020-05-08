package com.zju.nir.user.controller;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.user.entity.DoctorDO;
import com.zju.nir.user.entity.DoctorVO;
import com.zju.nir.user.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoguo
 */
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor/logreg")
    public ReturnResult<Integer> loginOrRegister(@RequestBody DoctorVO doctor) {

        return doctorService.loginOrRegister(new DoctorDO().setDoctorName(doctor.getDoctorName())
                .setId(doctor.getId())
                .setPassword(doctor.getPassword()));
    }

}
