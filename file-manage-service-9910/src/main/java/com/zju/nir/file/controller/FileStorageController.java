package com.zju.nir.file.controller;

import com.zju.nir.file.common.CommonFile;
import com.zju.nir.file.service.FileStorage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by white_wolf on 2020/5/10.
 *
 * @author thebestwj
 */
@Controller
public class FileStorageController implements InitializingBean {

    @Value("${lab-file-system.nginx.ip}")
    public String NGINX_SERVER_IP;

    @Value("${lab-file-system.nginx.port}")
    public String NGINX_SERVER_PORT;

    public String PREFIX;

    @Autowired
    FileStorage fileStorage;

    @PostMapping(value = "/upload")
    String uploadFile(@RequestBody @NotNull MultipartFile file){
        return "redirect:"+ uploadFileAndGetPath(file);
    }

    @ResponseBody
    @PostMapping(value = "/upload/path")
    String uploadFileAndGetPath(@RequestBody @NotNull MultipartFile file){
        CommonFile a;
        a = fileStorage.uploadFile(file);
        return PREFIX + a.getPath();
    }

    @GetMapping("/file/{id}")
    String getFileRedirect(@PathVariable Integer id){
        return "redirect:" + getFilePath(id);
    }

    @ResponseBody
    @DeleteMapping("/file/{id}")
    boolean deleteFile(@PathVariable Integer id){
        return fileStorage.deleteFile(id);
    }

    @ResponseBody
    @GetMapping("/file/path/{id}")
    String getFilePath(@PathVariable Integer id){
        return PREFIX + fileStorage.getFileById(id).getPath();
    }

    @Override
    public void afterPropertiesSet() {
        PREFIX = "http://" + NGINX_SERVER_IP +":" + NGINX_SERVER_PORT +"/";
    }
}
