package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserInfo;
import com.itheima.user.service.ApUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserInfoController",tags = "APP用户信息")
@RestController
@RequestMapping("/apUserInfo")
public class ApUserInfoController extends AbstractCoreController<ApUserInfo> {

    private ApUserInfoService apUserInfoService;

    @Autowired
    public ApUserInfoController(ApUserInfoService apUserInfoService) {
        super(apUserInfoService);
        this.apUserInfoService=apUserInfoService;
    }

}

