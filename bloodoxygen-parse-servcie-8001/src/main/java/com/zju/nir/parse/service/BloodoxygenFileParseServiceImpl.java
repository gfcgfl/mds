package com.zju.nir.parse.service;

import com.zju.nir.common.entity.Mark;
import com.zju.nir.common.entity.ParsedBloodoxygenFileData;
import com.zju.nir.common.entity.SingleChannelData;
import com.zju.nir.common.entity.SingleFrameData;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class BloodoxygenFileParseServiceImpl implements BloodoxygenFileParseService{


    @Override
    public void parseBloodoxygenFile(File bloodoxygenFile, ParsedBloodoxygenFileData result) {
        // todo 这里先模拟一下
        LinkedHashMap<Integer, SingleChannelData> mockMap = result.getChannelsData();
        if (mockMap == null) {
            mockMap = new LinkedHashMap<>();
            result.setChannelsData(mockMap);
        }
        SingleChannelData one = new SingleChannelData();
        Date time1 = new Date();
        List<SingleFrameData> channelData = new ArrayList<SingleFrameData>(){
            {

                add(new SingleFrameData().setFrameNum(1).setTime(time1)
                        .setDHb(2.0f).setDHbO2(0.2f)
                        .setDtHb(0.0f).setTHi(1.9f).setToi(0.98f));
                add(new SingleFrameData().setFrameNum(2).setTime(new Date())
                        .setDHb(2.34f).setDHbO2(6.23f)
                        .setDtHb(5.0f).setTHi(6.9f).setToi(0.68f));
                add(new SingleFrameData().setFrameNum(3).setTime(new Date())
                        .setDHb(2.0f).setDHbO2(66.2f)
                        .setDtHb(8.0f).setTHi(66.9f).setToi(6.98f));
            }
        };
        List<Mark> marks = new ArrayList<Mark>() {
            {
                add(new Mark().setMarkId(1).setFrameNum(1)
                        .setMarkTime(time1.toString()).setMarkName("mark名字"));
            }
        };
        one.setChannelData(channelData);
        result.setTaskMarks(marks);

        mockMap.put(1, one);
        mockMap.put(2, one);
    }
}
