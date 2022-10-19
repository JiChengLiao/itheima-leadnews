package com.itheima.common.vo;

import lombok.Data;

@Data
public class LoginResultVo extends ResultVo{
    private Object user;
    private String token;
}
