package com.zju.nir.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 描述报告存储的状态
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportStorageStatus {

    /**
     * 是否存储成功
     */
    private Boolean succeed;

//    /**
//     * 存储模式：本地 1 or 远程 10
//     */
//    private Integer storageMode;

    /**
     * 存储的路径 file模块的本地路径 or 在文件服务器中的url
     */
    private String path;


//    private String reportName;


//    public static final Integer STORAGE_MODE_LOCAL = 1;
//    public static final Integer STORAGE_MODE_REMOTE = 10;

}
