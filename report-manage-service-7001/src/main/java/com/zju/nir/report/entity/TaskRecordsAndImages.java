package com.zju.nir.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TaskRecordsAndImages {

    private String taskName;

    private List<File> taskImages;

    /**
     * 任务的一些得分之类的信息
     */
    private LinkedHashMap<String, Object> records;
}
