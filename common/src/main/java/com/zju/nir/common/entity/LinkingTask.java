package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class LinkingTask {
//    private Integer id;

    private Integer patientId;

    private Integer aWordMis;

    private Integer aWordTime;

//    private String aWordStart;
//
//    private String aWordEnd;

    private Integer bWordMis;

    private Integer bWordTime;


}