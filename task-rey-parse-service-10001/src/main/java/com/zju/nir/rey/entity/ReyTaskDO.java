package com.zju.nir.rey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReyTaskDO {
    private Integer id;

    private Integer patientId;

    private Integer collectId;

    private Integer reySiScore;

    private Integer reyDiScore;

    private Integer reySdScore;

    private Integer reyDdScore;

    private Date startTime;

    private Date endTime;

    private String bloodoxygenFilePath;


}