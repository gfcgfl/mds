package com.zju.nir.user.service;

import com.zju.nir.user.entity.PatientDO;

/**
 * @author xiaoguo
 */
public interface PatientService {


    PatientDO selectPatientById(int patientId);


    Integer selectPatientAdhdTypeById(int patientId);

    void updatePatient(PatientDO patientDO);

    void insertPatient(PatientDO patientDO);

    void addIntervene();

    void addAdhdTypeRecord(Integer patientId, Integer adhdType);
}
