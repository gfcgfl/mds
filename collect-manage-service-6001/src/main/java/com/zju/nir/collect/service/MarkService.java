package com.zju.nir.collect.service;


import com.zju.nir.common.entity.Mark;

import java.io.File;
import java.util.List;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
public interface MarkService {


    /**
     * 将marks信息添加到file中
     * @param marks
     * @param file
     * @return
     */
    File doMark(List<Mark> marks, File file);
}
