package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdFunction;
import com.itheima.admin.service.AdFunctionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>页面功能信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdFunctionController",tags = "页面功能信息")
@RestController
@RequestMapping("/adFunction")
public class AdFunctionController extends AbstractCoreController<AdFunction> {

    private AdFunctionService adFunctionService;

    @Autowired
    public AdFunctionController(AdFunctionService adFunctionService) {
        super(adFunctionService);
        this.adFunctionService=adFunctionService;
    }

}

