package com.zju.nir.collect.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xiaoguo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CollectVO {

//    private Integer id;

    private Integer patientId;

    private Integer doctorId;

    private String startTime;

//    private Date endTime;

//    private Date createTime;
}
