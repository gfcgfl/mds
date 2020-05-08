package com.zju.nir.parse.controller;

import com.alibaba.fastjson.JSONObject;
import com.zju.nir.common.entity.ParsedBloodoxygenFileData;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.utils.FileUtils;
import com.zju.nir.common.utils.JsonUtils;
import com.zju.nir.parse.service.BloodoxygenFileParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * @author xiaoguo
 */
@RestController
public class  ParseController {

    @Autowired
    private BloodoxygenFileParseService parseService;

    @GetMapping("/parse/url")
    public ReturnResult<ParsedBloodoxygenFileData> parseBloodoxygenFileByFileUrl(
            @RequestParam("fileUrl") String fileUrl) {


        ParsedBloodoxygenFileData parsedData = new ParsedBloodoxygenFileData();


        /**
         * 从url处获取文件
         */
        File file = FileUtils.getFileByUrl(fileUrl);

        /**
         * parse
         */
        try {
            parseService.parseBloodoxygenFile(file, parsedData);
        } catch (Exception e) {
            return new ReturnResult<>(ReturnResult.FAIL_CODE, "failed", null);
        }

        return new ReturnResult<>(ReturnResult.SUCCESS_CODE, "ok", parsedData);

    }

    private List<String> parseJson(String fileUrlList) {
        return JSONObject.parseArray(fileUrlList, String.class);
    }

}
