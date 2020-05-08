package com.zju.nir.report.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.zju.nir.common.entity.TaskDataDetail;
import com.zju.nir.report.config.ReportConfig;
import com.zju.nir.report.entity.ReportData;
import com.zju.nir.report.entity.TaskRecordsAndImages;
import com.zju.nir.report.util.PdfFontUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoguo
 */
@Service
public class ReportCreateServiceImpl implements ReportCreateService {

    @Autowired
    private BloodOxygenWaveformImgService waveformImgService;

    @Autowired
    private ReportConfig reportConfig;

    @Override
    public File createPdfReport(ReportData reportData) throws IOException, DocumentException {

        /**
         * 生成每个任务所需的图片
         */
        // 用于存储每个任务 对应的图片文件和数据记录
        Map<Integer, TaskRecordsAndImages> taskMap = new ConcurrentHashMap<>(10, 0.75f);
        for (TaskDataDetail taskDataDetail : reportData.getTaskDataDetail()) {
            // 每次for循环对应着一个任务

            // 根据taskDataDetail画通道数据波形图   todo 可以改为用多线程方式
            List<File> curTaskImgFiles = waveformImgService.createOneTaskImgFile(taskDataDetail);

            taskMap.put(
                    taskDataDetail.getTaskId(),
                    new TaskRecordsAndImages()
                            .setTaskName(taskDataDetail.getTaskName())
                            .setRecords(taskDataDetail.getRecords())
                            .setTaskImages(curTaskImgFiles)
            );

        }


        /**
         * 根据每个任务的图片以及任务的数据，生成pdf报告文件
         */
        File pdfReport;
        try {
            pdfReport = createPdf(taskMap, reportData);
        } finally {
            /**
             * 将临时性的图片文件删除    todo  todo  todo  todo  todo  todo  todo  todo
             */
//            for (TaskRecordsAndImages recordsAndImages : taskMap.values()) {
//                List<File> taskImages = recordsAndImages.getTaskImages();
//                if (taskImages != null) {
//                    for (File taskImage : taskImages) {
//                        taskImage.deleteOnExit();
//                    }
//                }
//            }

        }
        return pdfReport;
    }


    private File createPdf(Map<Integer, TaskRecordsAndImages> taskMap, ReportData reportData) throws IOException, DocumentException {

        File pdf = File.createTempFile("pdf-temp-file-" + UUID.randomUUID(), ".pdf");
        FileOutputStream file = new FileOutputStream(pdf);
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.

        PdfWriter.getInstance(document, file);
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        document.add(PdfFontUtils.getFont(1, "血氧报告"));
        document.add(PdfFontUtils.getFont(3, "基本信息"));
        document.add(PdfFontUtils.getFont(6, "用户编号ID：" + reportData.getPatientId()));
        document.add(PdfFontUtils.getFont(6, "采集编号ID：" + reportData.getCollectId()));
        Integer doctorId = reportData.getDoctorId();
        document.add(PdfFontUtils.getFont(6, "医师ID：" + (doctorId == null ? "" : doctorId)));
        document.add(PdfFontUtils.getFont(6, "采集开始时间：" + reportData.getStartTime()));
        document.add(PdfFontUtils.getFont(6, "采集结束时间" + reportData.getEndTime()));

        List<Integer> sequences = this.reportConfig.getReportTaskidSequence();
        for (Integer taskId : sequences) {
            TaskRecordsAndImages taskRecordsAndImages = taskMap.get(taskId);
            List<File> taskImages = taskRecordsAndImages.getTaskImages();

            document.newPage();
            document.add(PdfFontUtils.getFont(2, taskRecordsAndImages.getTaskName()));
            LinkedHashMap<String, Object> taskRecords = taskRecordsAndImages.getRecords();
            if (taskRecords != null) {
                document.add(PdfFontUtils.getFont(6, "任务详情：" + taskRecords.toString()));
            }
            //添加图片
            for (File taskImage : taskImages) {
                Image image = Image.getInstance(taskImage.getAbsolutePath());
                image.setAlignment(Image.LEFT);
                image.scaleToFit(document.getPageSize().getWidth() - 100, document.getPageSize().getHeight() / 5);
                document.add(image);
            }
        }

        document.close();

        return pdf;
    }

    private void deleteTempFiles(Map<Integer, List<File>> taskIdToImgFilesMap, File pdfReport) {
        for (List<File> taskImgFiles : taskIdToImgFilesMap.values()) {
            if (taskImgFiles == null) {
                continue;
            }
            for (File taskImgFile : taskImgFiles) {
                taskImgFile.deleteOnExit();
            }
        }
        if (pdfReport != null) {
            pdfReport.deleteOnExit();
        }
    }


}
