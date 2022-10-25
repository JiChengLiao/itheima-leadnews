package com.itheima.article.controller;


import com.itheima.article.pojo.ApDynamic;
import com.itheima.article.service.ApDynamicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户动态信息</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApDynamicController",tags = "APP用户动态信息")
@RestController
@RequestMapping("/apDynamic")
public class ApDynamicController extends AbstractCoreController<ApDynamic> {

    private ApDynamicService apDynamicService;

    @Autowired
    public ApDynamicController(ApDynamicService apDynamicService) {
        super(apDynamicService);
        this.apDynamicService=apDynamicService;
    }

}

