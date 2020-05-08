package com.zju.nir.report.service;

import com.zju.nir.common.entity.TaskDataDetail;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class BloodOxygenWaveformImgServiceImpl implements BloodOxygenWaveformImgService{
    @Override
    public List<File> createOneTaskImgFile(TaskDataDetail taskDataDetail) {

        // 先模拟一下  todo

        return new ArrayList<File>(){
            {
                add(new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system" +
                        "\\report-manage-service-7001\\src\\main\\resources\\IMG_20191102_100011.jpg"));
                add(new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system" +
                        "\\report-manage-service-7001\\src\\main\\resources\\IMG_20191102_100052.jpg"));
                add(new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system" +
                        "\\report-manage-service-7001\\src\\main\\resources\\IMG_20191102_100254.jpg"));
                add(new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system" +
                        "\\report-manage-service-7001\\src\\main\\resources\\IMG_20191102_112912.jpg"));
                add(new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system" +
                        "\\report-manage-service-7001\\src\\main\\resources\\IMG_20191102_140509.jpg"));
            }
        };
    }
}
