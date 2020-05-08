package com.zju.nir.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Mark {
    private Integer markId;
    /**
     * frameNum用于指示当前标记是标记在第几帧数据上
     */
    private Integer frameNum;
    private String markTime;
    private String markName;
}
