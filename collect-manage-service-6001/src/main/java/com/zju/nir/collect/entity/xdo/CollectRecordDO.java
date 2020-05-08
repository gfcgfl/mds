package com.zju.nir.collect.entity.xdo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CollectRecordDO {
    private Integer id;

    private Integer patientId;

    private Integer doctorId;

    private Date startTime;

    private Date endTime;

    private Date createTime;

}