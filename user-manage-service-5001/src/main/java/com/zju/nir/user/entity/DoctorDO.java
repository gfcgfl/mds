package com.zju.nir.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DoctorDO {
    private Integer id;

    private String doctorName;

    private String password;

    private Date createTime;

    private Date updateTime;

}