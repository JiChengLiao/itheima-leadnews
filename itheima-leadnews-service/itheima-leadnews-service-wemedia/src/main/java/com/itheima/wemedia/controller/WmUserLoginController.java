package com.itheima.wemedia.controller;


import com.itheima.wemedia.pojo.WmUserLogin;
import com.itheima.wemedia.service.WmUserLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体用户登录行为信息</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmUserLoginController",tags = "自媒体用户登录行为信息")
@RestController
@RequestMapping("/wmUserLogin")
public class WmUserLoginController extends AbstractCoreController<WmUserLogin> {

    private WmUserLoginService wmUserLoginService;

    @Autowired
    public WmUserLoginController(WmUserLoginService wmUserLoginService) {
        super(wmUserLoginService);
        this.wmUserLoginService=wmUserLoginService;
    }

}

