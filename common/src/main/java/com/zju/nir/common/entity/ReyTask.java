package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReyTask {

    private Integer patientId;

    private Integer reySiScore;

    private Integer reyDiScore;

//    private String reyPresentStart;
//
//    private String reyPresentEnd;

    private Integer reySdScore;

    private Integer reyDdScore;


}