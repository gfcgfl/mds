package com.zju.nir.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportMessage {

    /**
     * 报告是否生成成功
     */
    private Boolean created;



    private ReportStorageStatus storageStatus;

    /**
     * 通过重定向方式访问 报告文件时 的重定向路径
     */
    private String redirectPath;
}
