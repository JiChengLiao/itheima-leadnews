package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserIdentity;
import com.itheima.user.service.ApUserIdentityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP身份认证信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserIdentityController",tags = "APP身份认证信息")
@RestController
@RequestMapping("/apUserIdentity")
public class ApUserIdentityController extends AbstractCoreController<ApUserIdentity> {

    private ApUserIdentityService apUserIdentityService;

    @Autowired
    public ApUserIdentityController(ApUserIdentityService apUserIdentityService) {
        super(apUserIdentityService);
        this.apUserIdentityService=apUserIdentityService;
    }

}

