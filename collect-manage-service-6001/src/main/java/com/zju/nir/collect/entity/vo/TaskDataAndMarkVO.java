package com.zju.nir.collect.entity.vo;


import com.zju.nir.common.entity.Mark;
import com.zju.nir.common.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TaskDataAndMarkVO {
    private List<Mark> marks;
    private Integer taskId;
    private ReyTask task1;
    private LinkingTask task2;
    private StroopTask task3;
    private RestTask task4;
    private SnapTask task5;

    private Integer patientId;
    private Integer collectId;
    private String startTime;
    private String endTime;

}
