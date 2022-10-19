package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdUserLogin;
import com.itheima.admin.service.AdUserLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>管理员登录行为信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdUserLoginController",tags = "管理员登录行为信息")
@RestController
@RequestMapping("/adUserLogin")
public class AdUserLoginController extends AbstractCoreController<AdUserLogin> {

    private AdUserLoginService adUserLoginService;

    @Autowired
    public AdUserLoginController(AdUserLoginService adUserLoginService) {
        super(adUserLoginService);
        this.adUserLoginService=adUserLoginService;
    }

}

