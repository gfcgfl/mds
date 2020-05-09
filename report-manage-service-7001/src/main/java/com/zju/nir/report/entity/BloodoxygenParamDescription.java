package com.zju.nir.report.entity;

import com.zju.nir.common.entity.Mark;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用于描述某一个通道中一个血氧参数的一些信息
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BloodoxygenParamDescription {

    /**
     * 当前参数所属通道
     */
    private Integer channel;

    /**
     * 血氧参数的简写
     */
    private String paramAbbreviation;

    /**
     * 血氧参数全称
     */
    private String paramFullName;

    /**
     * 参数的单位
     */
    private String unit;

    /**
     * 此血氧参数（在当前通道中）数据的上界
     */
    private Float up;

    /**
     * 此血氧参数（在当前通道中）数据的下界
     */
    private Float low;

    /**
     * 当前参数在通道数据中出现的个数 （也就是等于通道的数据帧数）
     */
    private Integer count;

    /**
     * 通道中的标识
     */
    private List<Mark> marks;

    /**
     * 参数的具体的值
     */
    private float[] paramValues;

}
