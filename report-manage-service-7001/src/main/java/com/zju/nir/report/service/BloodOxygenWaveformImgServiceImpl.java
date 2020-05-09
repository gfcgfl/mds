package com.zju.nir.report.service;

import com.zju.nir.common.entity.Mark;
import com.zju.nir.common.entity.SingleChannelData;
import com.zju.nir.common.entity.SingleFrameData;
import com.zju.nir.common.entity.TaskDataDetail;
import com.zju.nir.report.core.Draw;
import com.zju.nir.report.entity.BloodoxygenParamDescription;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static com.zju.nir.common.constant.BloodoxygenParamsConstant.BLOODOXYGEN_PARAM_INFO;

/**
 * @author xiaoguo
 */
@Service
public class BloodOxygenWaveformImgServiceImpl implements BloodOxygenWaveformImgService {

    @Override
    public List<File> createOneTaskImgFile(TaskDataDetail taskDataDetail) {


        LinkedHashMap<Integer, SingleChannelData> channelsData = taskDataDetail.getChannelsData();
        if (CollectionUtils.isEmpty(channelsData)) {
            return Collections.emptyList();
        }

        /**
         * 这里只画一个通道
         */
        int selectedChannel = 0;
        SingleChannelData selectedChannelData = null;
        for (Map.Entry<Integer, SingleChannelData> entry : channelsData.entrySet()) {
            selectedChannel = entry.getKey();
            selectedChannelData = entry.getValue();
            break;
        }
        List<Mark> marks = taskDataDetail.getMarks();
        List<File> singleChannelImgFiles = drawSingleChannelWaveforms(selectedChannel, selectedChannelData, marks);
        return singleChannelImgFiles;

    }

    private List<File> drawSingleChannelWaveforms(int selectedChannel,
                                                  SingleChannelData selectedChannelDataAndMark,
                                                  List<Mark> marks) {

        // 下面的代码 获取到每个通道的描述信息
        List<BloodoxygenParamDescription> descriptions
                = getParamDescriptionsOfSelectedChannel(selectedChannel, selectedChannelDataAndMark, marks);

        List<File> res = new ArrayList<>(descriptions.size());
        descriptions.forEach(description -> {
            Draw draw = new Draw(description);
            File drawedFile = draw.draw();
            if (drawedFile != null) {
                res.add(drawedFile);
            }

        });

        return res;

    }

    private List<BloodoxygenParamDescription> getParamDescriptionsOfSelectedChannel(
            int selectedChannel,
            SingleChannelData selectedChannelDataAndMark,
            List<Mark> marks) {

        // len保存实际应该有多少帧数据 也就是它等于最后一帧的帧编号而不是等于data的size（正常情况两者是相等的）
        // 但是考虑到可能会出现 size=2，两个帧的编号却分别是1,3的情况，此时len=3
        int len;
        List<SingleFrameData> data = selectedChannelDataAndMark.getChannelData();
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        if (data instanceof ArrayList) {
            len = data.get(data.size() - 1).getFrameNum();
        } else {
            len = ((LinkedList<SingleFrameData>) data).getLast().getFrameNum();
        }

        List<String[]> paramInfo = BLOODOXYGEN_PARAM_INFO;
        List<BloodoxygenParamDescription> result = new ArrayList<>(paramInfo.size());
        for (String[] entry : paramInfo) {
            // 每次循环对应着一个血氧参数
            String abbreviation = entry[0];
            String fullname = entry[1];
            String unit = entry[2];

            // 获取当前参数的在当前通道中的最小值和最大值
            BloodoxygenParamDescription description;
            try {
                description = new BloodoxygenParamDescription()
                        .setCount(len)
                        .setChannel(selectedChannel)
                        .setParamAbbreviation(abbreviation)
                        .setParamFullName(fullname)
                        .setUnit(unit)
                        .setMarks(marks);
                padding(abbreviation, selectedChannelDataAndMark, len, description);
            } catch (Exception e) {
                continue;
            }
            result.add(description);
        }

        return result;
    }

    /**
     * 此方法通过反射的方式获取到当前参数的参数值以及上下界
     */
    private void padding(String abbreviation,
                         SingleChannelData selectedChannelDataAndMark,
                         int len,
                         BloodoxygenParamDescription targetDescription)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NullPointerException {

        Class<SingleFrameData> sourceClass = SingleFrameData.class;
        Iterator<SingleFrameData> iterator = selectedChannelDataAndMark.getChannelData().iterator();
        SingleFrameData first = iterator.next();
        Method getter = getterMethod(sourceClass, abbreviation);
        float[] paramValues = new float[len];
        paramValues[0] = (float) getter.invoke(first);
        float low = paramValues[0];
        float up = low;

        int i = 1;
        while (iterator.hasNext()) {
            SingleFrameData one = iterator.next();
            float value = (Float) getter.invoke(one);
            if (value < low) {
                low = value;
            } else if (value > up) {
                up = value;
            }
            paramValues[i++] = value;
        }

        targetDescription.setLow(low)
                .setUp(up)
                .setParamValues(paramValues);
    }


    /**
     * 获取到getter方法
     *
     * @param sourceClass
     * @param paramAbbreviation
     * @return
     * @throws NoSuchMethodException
     */
    private Method getterMethod(Class<?> sourceClass, String paramAbbreviation) throws NoSuchMethodException {
        char firstChar = (char) (paramAbbreviation.charAt(0) - 32);
        return sourceClass.getDeclaredMethod("get" + firstChar + paramAbbreviation.substring(1));
    }
}
