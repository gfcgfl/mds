package com.zju.nir.stroop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class StroopTaskDO {
    private Integer id;

    private Integer patientId;

    private Integer collectId;

    private Integer aStroopMis;

    private Integer aStroopTime;

    private Integer bStroopMis;

    private Integer bStroopTime;

    private Integer cStroopMis;

    private Integer cStroopTime;

    private Integer dStroopMis;

    private Integer dStroopTime;

    private Date startTime;

    private Date endTime;

    private String bloodoxygenFilePath;


}