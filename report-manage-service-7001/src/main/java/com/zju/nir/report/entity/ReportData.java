package com.zju.nir.report.entity;

import com.zju.nir.common.entity.TaskDataDetail;
import com.zju.nir.common.entity.TaskDataRecord;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportData {

    private Integer collectId;

    private Integer patientId;

    private Integer doctorId;

    private Date startTime;

    private Date endTime;

//    private Integer reportId;
    /**
     * 每个任务的详情信息
     */
    private List<TaskDataDetail> taskDataDetail;

//    /**
//     * 存储每个任务的血氧数据
//     */
//    private Map<TaskTypeEnum, BloodOxygenInfoForTask> taskBloodOxygenInfo;
//
//
//    /**
//     * 单个任务的血样数据
//     */
//    @Data
//    public static class BloodOxygenInfoForTask {
//
//        /**
//         * 这里存储的是任务的血氧数据文件的绝对路径
//         */
//        private String filePath;
//    }
//
//    /**
//     * 单个任务的得分信息
//     */
//    @Data
//    public static class ScoreInfoForTask {
//
//
//        /**
//         * key： 得分项
//         * value：分值
//         */
//        private LinkedHashMap<String, Integer> scoreMap;
//
//
//
//        public void addScore(String item, Integer score) {
//            if (this.scoreMap == null) {
//                this.scoreMap = new LinkedHashMap<>();
//            }
//            this.scoreMap.put(item, score);
//        }
//    }
}
