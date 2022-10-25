package com.itheima.wemedia.controller;

import com.itheima.common.vo.LoginResultVo;
import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.service.WmUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/login")
@RestController
@Api("自媒体登录")
public class LoginController {

    @Resource
    private WmUserService wmUserService;

    /**
     * 自媒体登录校验
     * @param paramMap
     * @return
     */
    @ApiOperation("自媒体登录校验")
    @PostMapping("/in")
    public ResultVo loginCheck(@RequestBody Map<String,String>paramMap){
        LoginResultVo vo=wmUserService.login(paramMap);
return ResultVo.ok(vo);

    }
}
