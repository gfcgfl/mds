package com.zju.nir.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
public class DoctorVO {

    private Integer id;

    private String doctorName;

    private String password;

}
