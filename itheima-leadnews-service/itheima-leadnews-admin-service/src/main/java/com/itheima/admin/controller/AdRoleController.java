package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdRole;
import com.itheima.admin.service.AdRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>角色信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdRoleController",tags = "角色信息")
@RestController
@RequestMapping("/adRole")
public class AdRoleController extends AbstractCoreController<AdRole> {

    private AdRoleService adRoleService;

    @Autowired
    public AdRoleController(AdRoleService adRoleService) {
        super(adRoleService);
        this.adRoleService=adRoleService;
    }

}

