package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdUserOpertion;
import com.itheima.admin.service.AdUserOpertionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>管理员操作行为信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdUserOpertionController",tags = "管理员操作行为信息")
@RestController
@RequestMapping("/adUserOpertion")
public class AdUserOpertionController extends AbstractCoreController<AdUserOpertion> {

    private AdUserOpertionService adUserOpertionService;

    @Autowired
    public AdUserOpertionController(AdUserOpertionService adUserOpertionService) {
        super(adUserOpertionService);
        this.adUserOpertionService=adUserOpertionService;
    }

}

