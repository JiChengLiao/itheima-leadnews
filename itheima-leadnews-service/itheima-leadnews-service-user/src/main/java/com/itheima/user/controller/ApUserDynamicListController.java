package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserDynamicList;
import com.itheima.user.service.ApUserDynamicListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户动态列</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserDynamicListController",tags = "APP用户动态列")
@RestController
@RequestMapping("/apUserDynamicList")
public class ApUserDynamicListController extends AbstractCoreController<ApUserDynamicList> {

    private ApUserDynamicListService apUserDynamicListService;

    @Autowired
    public ApUserDynamicListController(ApUserDynamicListService apUserDynamicListService) {
        super(apUserDynamicListService);
        this.apUserDynamicListService=apUserDynamicListService;
    }

}

