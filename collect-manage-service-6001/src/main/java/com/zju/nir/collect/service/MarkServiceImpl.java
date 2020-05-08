package com.zju.nir.collect.service;

import com.zju.nir.common.entity.Mark;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@Slf4j
@Service
public class MarkServiceImpl implements MarkService {

    private static final String rePattern = "\\d+/\\d+/\\d+ \\d+:\\d+:\\d+.*?";
    /**
     * 时间格式
     */
    public static final String formatterString = "yyyy/MM/dd HH:mm:ss";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterString);

    @Override
    public File doMark(List<Mark> marks, File file) {

        //没有标记
        if (null == marks || marks.size() < 1) {
            return null;
        }

        File targetFile = null;
        try {
            targetFile = File.createTempFile(UUID.randomUUID().toString(), "mark-tmp");
        } catch (IOException e) {
            return null;
        }

        try (
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))
        ){
            String temp = br.readLine();
            List<Mark> marksToMark = new ArrayList<>(marks);
            while (temp != null) {
                StringBuilder outTemp = new StringBuilder(temp);
                if (temp.matches(rePattern)) {
                    LocalDateTime recordTime = LocalDateTime.parse(temp.substring(0,formatterString.length()), formatter);
                    for (Mark mark : marksToMark) {
                        LocalDateTime markTime = LocalDateTime.parse(mark.getMarkTime(), formatter);
                        Duration duration = Duration.between(recordTime,markTime);
                        if (!duration.isNegative() && duration.getSeconds()<=1) {
                            outTemp.append("\t\tmark" + mark.getMarkId() + ":" + mark.getMarkName());
                        }
                    }
                }

                bw.write(outTemp.toString());
                bw.newLine();
                temp = br.readLine();
            }

        } catch (IOException e) {
            log.warn("mark失败");
            e.printStackTrace();
            return null;
        }

        return targetFile;
    }
}
