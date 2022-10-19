package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdRoleAuth;
import com.itheima.admin.service.AdRoleAuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>角色权限信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdRoleAuthController",tags = "角色权限信息")
@RestController
@RequestMapping("/adRoleAuth")
public class AdRoleAuthController extends AbstractCoreController<AdRoleAuth> {

    private AdRoleAuthService adRoleAuthService;

    @Autowired
    public AdRoleAuthController(AdRoleAuthService adRoleAuthService) {
        super(adRoleAuthService);
        this.adRoleAuthService=adRoleAuthService;
    }

}

