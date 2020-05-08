package com.zju.nir.rest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RestTaskDO {
    private Integer id;

    private Integer patientId;

    private Integer collectId;

    private Date startTime;

    private Date endTime;

    private String bloodoxygenFilePath;


}