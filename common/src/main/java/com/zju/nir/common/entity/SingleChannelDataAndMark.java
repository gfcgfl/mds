package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 单个通道的数据和标记
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SingleChannelDataAndMark {

    /**
     * 一个通道中的所有帧
     */
    private List<SingleFrameData> channelData;



}
