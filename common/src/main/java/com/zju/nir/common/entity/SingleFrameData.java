package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 血氧仪每一帧数据（若干帧数据组合为一个通道的数据）
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SingleFrameData {

    private Date time;

    private Integer frameNum;

    private Float toi;

    private Float tHi;

    private Float dHb;

    private Float dHbO2;

    private Float dtHb;
}
