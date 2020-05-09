package com.zju.nir.link.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class LinkingTaskDO {
    private Integer id;

    private Integer patientId;

    private Integer collectId;

    private Integer aWordMis;

    private Integer aWordTime;

    private Integer bWordMis;

    private Integer bWordTime;

    private Date startTime;

    private Date endTime;

    private String bloodoxygenFilePath;


}