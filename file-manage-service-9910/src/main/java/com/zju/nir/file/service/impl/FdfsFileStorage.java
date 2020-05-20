package com.zju.nir.file.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zju.nir.file.common.CommonFile;
import com.zju.nir.file.mapper.FdfsFileMapper;
import com.zju.nir.file.model.FdfsFile;
import com.zju.nir.file.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by white_wolf on 2020/5/10.
 *
 * @author thebestwj
 */
@Service
public class FdfsFileStorage implements FileStorage {

    @Autowired
    FdfsFileMapper mapper;

    @Autowired
    FastFileStorageClient storageClient;

    Map<String,String> supportedTypes = new HashMap<>();

    /**
     * 设置支持的类型
     */
    {
        supportedTypes.put(MimeTypeUtils.IMAGE_JPEG_VALUE,"jpg");
        supportedTypes.put(MimeTypeUtils.IMAGE_PNG_VALUE,"png");
    }

    private String getSupportedType(String type){
        if (supportedTypes.containsKey(type)){
            return supportedTypes.get(type);
        } else throw new RuntimeException("文件格式不支持:"+type);
    }


//    @Override
//    public CommonFile uploadFile(File file) {
//        InputStream is = null;
//        if(!file.exists()) return null;
//
//        try {
//            is = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//            Set<MetaData> metaDataSet=null;
//            StorePath path = storageClient.uploadFile(is,file.length(), file.getName(),metaDataSet);
//
//        FdfsFile fdfsFile = new FdfsFile();
//        fdfsFile.setPath(path.getFullPath());
//        fdfsFile.setName(file.getName());
//        fdfsFile.setCreateTime(new Date());
//        System.out.println(path.getFullPath());
//        return fdfsFile;
//    }

    @Override
    public CommonFile uploadFile(MultipartFile file) {
        Assert.notNull(file,"没有上传文件");
        Set<MetaData> metaDataSet=null;
        StorePath path = null;

        String suffix = getSupportedType(file.getContentType());

        try {
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getSize());
            System.out.println(file.getContentType());
            path = storageClient.uploadFile(file.getInputStream(),file.getSize(),suffix,
                    metaDataSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FdfsFile fdfsFile = new FdfsFile();
        fdfsFile.setPath(path.getFullPath());
        fdfsFile.setName(file.getOriginalFilename());
        fdfsFile.setCreateTime(new Date());
        System.out.println(path.getFullPath());
        mapper.insert(fdfsFile);
        return fdfsFile;
    }


    @Override
    @Cacheable(cacheNames = "fileRecord",key = "#id")
    public CommonFile getFileById(Integer id) {
        Assert.notNull(id,"文件 id 为空");
        CommonFile file = mapper.selectByPrimaryKey(id);
        if (null == file) throw new RuntimeException("文件不存在");
        return file;
    }

    @Override
    @CacheEvict(cacheNames = "fileRecord",key = "#id")
    public boolean deleteFile(Integer id) {
        CommonFile file = getFileById(id);
        Assert.notNull(file,"文件不存在");
        mapper.deleteByPrimaryKey(id);
        storageClient.deleteFile(file.getPath());
        return true;
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        supportedTypes.keySet().forEach(System.out::println);
    }

}
