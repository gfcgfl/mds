package com.zju.nir.parse.service;

import com.zju.nir.common.entity.ParsedBloodoxygenFileData;

import java.io.File;

/**
 * @author xiaoguo
 */
public interface BloodoxygenFileParseService {

    /**
     * 解析文件
     */
    void parseBloodoxygenFile(File bloodoxygenFile, ParsedBloodoxygenFileData result);
}
