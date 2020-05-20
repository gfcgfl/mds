package com.zju.nir.file.service;

import com.zju.nir.file.common.CommonFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by white_wolf on 2020/5/10.
 *
 * @author thebestwj
 */
public interface FileStorage {
    //CommonFile uploadFile(File file);
    CommonFile uploadFile(MultipartFile file);
    CommonFile getFileById(Integer id);
    boolean deleteFile(Integer id);
}
