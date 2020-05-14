package com.zju.nir.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PatientInfoVO {

    private String id;

    private String name;

    private String gender;

    private String age;

    private String weight;

    private String height;

    private String adhdType;

    private String doctorName;


    private String intervene;

    private String interveneMethod;
    
    private String exists;

    //todo 后边再添加 临床信息
}
