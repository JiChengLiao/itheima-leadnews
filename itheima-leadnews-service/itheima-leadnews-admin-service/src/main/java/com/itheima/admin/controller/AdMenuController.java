package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdMenu;
import com.itheima.admin.service.AdMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>菜单资源信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdMenuController",tags = "菜单资源信息")
@RestController
@RequestMapping("/adMenu")
public class AdMenuController extends AbstractCoreController<AdMenu> {

    private AdMenuService adMenuService;

    @Autowired
    public AdMenuController(AdMenuService adMenuService) {
        super(adMenuService);
        this.adMenuService=adMenuService;
    }

}

