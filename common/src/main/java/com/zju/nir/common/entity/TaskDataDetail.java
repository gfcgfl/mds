package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TaskDataDetail extends TaskDataRecord {


    /**
     * 为null或者为空说明不存在标记
     */
    private List<Mark> marks;

    /**
     * key: 第几个通道
     * value： 这个通道的数据
     */
    private LinkedHashMap<Integer, SingleChannelData> channelsData;

}
