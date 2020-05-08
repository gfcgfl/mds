package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class StroopTask {
//    private Integer id;

    private Integer userId;

    private Integer aStroopMis;

    private Integer aStroopTime;

//    private String aStroopStart;
//
//    private String aStroopEnd;

    private Integer bStroopMis;

    private Integer bStroopTime;

//    private String bStroopStart;
//
//    private String bStroopEnd;

    private Integer cStroopMis;

    private Integer cStroopTime;

//    private String cStroopStart;
//
//    private String cStroopEnd;

    private Integer dStroopMis;

    private Integer dStroopTime;


}