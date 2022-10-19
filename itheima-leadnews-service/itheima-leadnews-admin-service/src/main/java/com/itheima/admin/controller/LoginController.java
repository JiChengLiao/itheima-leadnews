package com.itheima.admin.controller;


import com.itheima.admin.service.AdUserLoginService;
import com.itheima.admin.service.AdUserService;
import com.itheima.common.vo.LoginResultVo;
import com.itheima.common.vo.ResultVo;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/login")
@ApiModel("登录模块")
public class LoginController {

    @Resource
    private AdUserService adUserService;
    
    @PostMapping("/in")
    public ResultVo login(@RequestBody Map<String,String>paraMap){

        LoginResultVo login = adUserService.login(paraMap);

        return ResultVo.ok(login);

    }

}
