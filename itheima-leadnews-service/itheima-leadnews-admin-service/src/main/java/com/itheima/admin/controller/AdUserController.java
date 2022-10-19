package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdUser;
import com.itheima.admin.service.AdUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>管理员用户信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdUserController",tags = "管理员用户信息")
@RestController
@RequestMapping("/adUser")
public class AdUserController extends AbstractCoreController<AdUser> {

    private AdUserService adUserService;

    @Autowired
    public AdUserController(AdUserService adUserService) {
        super(adUserService);
        this.adUserService=adUserService;
    }

}

