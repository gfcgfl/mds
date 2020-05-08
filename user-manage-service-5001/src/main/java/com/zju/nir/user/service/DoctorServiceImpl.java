package com.zju.nir.user.service;

import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.user.entity.DoctorDO;
import com.zju.nir.user.entity.DoctorDOExample;
import com.zju.nir.user.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;


    @Override
    public ReturnResult<Integer> loginOrRegister(DoctorDO doctor) {

        ReturnResult<Integer> ret = new ReturnResult<>();
        Integer id;
        if ((id = doctor.getId()) == null && doctor.getDoctorName() == null) {
            ret.setCode(ReturnResult.LOGIC_ERROR_CODE);
            ret.setMsg("逻辑错误： 必须指定id或者名称！");
            return ret;
        }

        //查询是否已存在
        DoctorDO doctorDO = isExist(doctor);

        if (doctorDO != null) {
            if (testMatch(doctor, doctorDO)) {
                ret.setMsg("id: " + id + " 登录成功");
                ret.setCode(ReturnResult.SUCCESS_CODE);
                ret.setData(id);
            } else {
                ret.setCode(ReturnResult.LOGIN_ERROR_CODE);
                ret.setMsg("用户名或者密码错误");
            }
            return ret;
        }

        //注册
        // todo 暂时先设置为必须指定id
        if (id == null) {
            ret.setCode(ReturnResult.LOGIC_ERROR_CODE);
            ret.setMsg("注册的时候必须指定id");
        } else {
            Date date = new Date();
            doctor.setCreateTime(date);
            doctor.setUpdateTime(date);
            int result = doctorMapper.insert(doctor);
            if (result > 0) {
                ret.setCode(ReturnResult.SUCCESS_CODE);
                ret.setData(id);
                ret.setMsg("注册成功，id为 " + id);
            }
        }

        return ret;
    }

    private DoctorDO isExist(DoctorDO doctor) {
        DoctorDO ret;
        if (doctor.getId() != null) {
            ret = doctorMapper.selectByPrimaryKey(doctor.getId());
        } else {
            DoctorDOExample example = new DoctorDOExample();
            DoctorDOExample.Criteria criteria = example.createCriteria();
            criteria.andDoctorNameEqualTo(doctor.getDoctorName());
            List<DoctorDO> list = doctorMapper.selectByExample(example);
            ret = CollectionUtils.isEmpty(list) ? null : list.get(0);
        }
        return ret;
    }

    private boolean testMatch(DoctorDO a, DoctorDO b) {
        String p1, p2;
        return (p1 = a.getPassword()) != null && (p2 = b.getPassword()) != null
                && p1.equals(p2);
    }


    @Override
    public ReturnResult update(DoctorDO doctor) {
        return null;
    }


    @Override
    public ReturnResult modifyPswd(String old, String newPswd) {
        return null;
    }
}
