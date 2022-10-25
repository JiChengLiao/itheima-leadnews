package com.itheima.user.controller;


import com.itheima.user.pojo.ApUser;
import com.itheima.user.service.ApUserService;
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
@Api(value="ApUserController",tags = "APP用户信息")
@RestController
@RequestMapping("/apUser")
public class ApUserController extends AbstractCoreController<ApUser> {

    private ApUserService apUserService;

    @Autowired
    public ApUserController(ApUserService apUserService) {
        super(apUserService);
        this.apUserService=apUserService;
    }

}

