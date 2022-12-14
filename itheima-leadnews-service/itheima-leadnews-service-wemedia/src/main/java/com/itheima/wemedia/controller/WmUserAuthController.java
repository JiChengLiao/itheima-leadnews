package com.itheima.wemedia.controller;


import com.itheima.wemedia.pojo.WmUserAuth;
import com.itheima.wemedia.service.WmUserAuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体子账号权限信息</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmUserAuthController",tags = "自媒体子账号权限信息")
@RestController
@RequestMapping("/wmUserAuth")
public class WmUserAuthController extends AbstractCoreController<WmUserAuth> {

    private WmUserAuthService wmUserAuthService;

    @Autowired
    public WmUserAuthController(WmUserAuthService wmUserAuthService) {
        super(wmUserAuthService);
        this.wmUserAuthService=wmUserAuthService;
    }

}

