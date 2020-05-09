package com.zju.nir.common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoguo
 */
public class BloodoxygenParamsConstant {

 
//    public static final TreeMap<String, String> BLOODOXYGEN_PARAM_ABBREVIATION_TO_FULLNAME = new TreeMap<String, String>(){
//        {
//            put("toi", "toi的全称（后边填写）");
//            put("tHi", "tHi的全称（后边填写）");
//            put("dHb", "dHb的全称（后边填写）");
//            put("dHbO2", "dHbO2的全称（后边填写）");
//            put("dtHb", "dtHb的全称（后边填写）");
//        }
//    };

    /**
     * 0 简写
     * 1 全称
     * 2 单位
     */
    public static final List<String[]> BLOODOXYGEN_PARAM_INFO = new ArrayList<String[]>() {
        {
            add(new String[] {"toi", "toi的全称（后边填写）", "单位"});
            add(new String[] {"tHi", "tHi的全称（后边填写）", "单位"});
            add(new String[] {"dHb", "dHb的全称（后边填写）", "单位"});
            add(new String[] {"dHbO2", "dHbO2的全称（后边填写）", "单位"});
            add(new String[] {"dtHb", "dtHb的全称（后边填写）", "单位"});
        }
    };
             

}
