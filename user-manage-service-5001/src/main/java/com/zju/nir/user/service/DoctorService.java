package com.zju.nir.user.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.user.entity.DoctorDO;


/**
 * @author xiaoguo
 */
public interface DoctorService {

    /**
     * 登录或者注册
     * @param doctor
     * @return
     */
    ReturnResult<Integer> loginOrRegister(DoctorDO doctor);


    /**
     * todo
     * @param doctor
     * @return
     */
    ReturnResult update(DoctorDO doctor);


    /**
     * todo
     * @param old
     * @param newPswd
     * @return
     */
    ReturnResult modifyPswd(String old, String newPswd);


}
