package com.zju.nir.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PatientDO {
    private Integer id;

    private String name;

    private Integer gender;

    private Integer age;

    private String weight;

    private String height;

    private String password;

    private Date createTime;

    private Date updateTime;

}