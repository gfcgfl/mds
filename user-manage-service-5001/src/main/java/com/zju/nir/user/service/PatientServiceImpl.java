package com.zju.nir.user.service;

import com.zju.nir.user.entity.PatientDO;
import com.zju.nir.user.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoguo
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public PatientDO selectPatientById(int patientId) {
        return patientMapper.selectByPrimaryKey(patientId);
    }

    @Override
    public Integer selectPatientAdhdTypeById(int patientId) {
        return patientMapper.selectPatientAdhdTypeById(patientId);
    }

    @Override
    public void updatePatient(PatientDO patientDO) {
        patientMapper.updateByPrimaryKeySelective(patientDO);
    }

    @Override
    public void insertPatient(PatientDO patientDO) {
        patientMapper.insertSelective(patientDO);
    }

    @Override
    public void addIntervene() {

    }

    @Override
    public void addAdhdTypeRecord(Integer patientId, Integer adhdType) {
        patientMapper.addAdhdType(patientId, adhdType);
    }
}
