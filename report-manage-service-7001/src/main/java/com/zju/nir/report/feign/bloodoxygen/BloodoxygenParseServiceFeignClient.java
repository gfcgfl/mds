package com.zju.nir.report.feign.bloodoxygen;

import com.zju.nir.common.constant.BloodOxygenParseServiceConstant;
import com.zju.nir.common.entity.ParsedBloodoxygenFileData;
import com.zju.nir.common.entity.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaoguo
 */
@Component
@FeignClient(value = BloodOxygenParseServiceConstant.BLOODOXYGEN_PARSE_SERVICE_NAME)
public interface BloodoxygenParseServiceFeignClient {


    /**
     * 根据fileUrl调用解析模块，返回对文件解析后的结果
     * @param fileUrl
     * @return
     */
    @GetMapping("/parse/url")
    ReturnResult<ParsedBloodoxygenFileData> getParsedDataByFile(@RequestParam("fileUrl") String fileUrl);
}
