package com.zju.nir.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaoguo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ReturnResult<T> {

    public static Integer SUCCESS_CODE = 200;

    public static Integer LOGIC_ERROR_CODE = 10001;

    public static Integer LOGIN_ERROR_CODE = 10010;

    public static Integer DB_ERROR_CODE = 10100;

    public static Integer INTERNAL_ERROR_CODE = 11000;
    public static Integer FAIL_CODE = 11001;




    private Integer code;

    private String msg;

    private T data;

}
