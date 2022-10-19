package com.itheima.common.vo;

import com.itheima.common.enums.HttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.common.vo
 */
@Data
@AllArgsConstructor
public class ResultVo<T> implements Serializable {

    private String host;

    private Integer code;

    private String errorMessage;

    private T data;

    public ResultVo() {
        this.code = HttpCodeEnum.SUCCESS.getCode();
    }

    public static ResultVo ok() {
        return new ResultVo();
    }

    public static ResultVo ok(String msg) {
        return new ResultVo(null,HttpCodeEnum.SUCCESS.getCode(),msg,null);
    }

    public static ResultVo ok(Object data) {
        return new ResultVo(null,HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getMessage(),data);
    }
    public static ResultVo error() {
        return ResultVo.error(HttpCodeEnum.SERVER_ERROR);
    }
    public static ResultVo error(int code, String msg) {
        return new ResultVo(null,code,msg,null);
    }
    public static ResultVo error(HttpCodeEnum enums){
        return ResultVo.error(enums.getCode(),enums.getMessage());
    }
    public static ResultVo bizError(String msg) {
        return ResultVo.error(HttpCodeEnum.SERVER_ERROR.getCode(), msg);
    }

    public boolean isSuccess(){
        return this.code!=null&&this.code.intValue()==HttpCodeEnum.SUCCESS.getCode();
    }
}
