package com.zju.nir.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 某一个任务解析后的血样文件的数据
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ParsedBloodoxygenFileData {

    private List<Mark> taskMarks;

    /**
     * key: 第几个通道
     * value： 这个通道的数据
     */
    private LinkedHashMap<Integer, SingleChannelDataAndMark> channelsData;

}
