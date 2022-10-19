package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdUserRole;
import com.itheima.admin.service.AdUserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>管理员角色信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdUserRoleController",tags = "管理员角色信息")
@RestController
@RequestMapping("/adUserRole")
public class AdUserRoleController extends AbstractCoreController<AdUserRole> {

    private AdUserRoleService adUserRoleService;

    @Autowired
    public AdUserRoleController(AdUserRoleService adUserRoleService) {
        super(adUserRoleService);
        this.adUserRoleService=adUserRoleService;
    }

}

