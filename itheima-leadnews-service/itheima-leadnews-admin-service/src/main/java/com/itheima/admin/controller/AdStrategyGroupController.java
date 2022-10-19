package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdStrategyGroup;
import com.itheima.admin.service.AdStrategyGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>推荐策略分组信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdStrategyGroupController",tags = "推荐策略分组信息")
@RestController
@RequestMapping("/adStrategyGroup")
public class AdStrategyGroupController extends AbstractCoreController<AdStrategyGroup> {

    private AdStrategyGroupService adStrategyGroupService;

    @Autowired
    public AdStrategyGroupController(AdStrategyGroupService adStrategyGroupService) {
        super(adStrategyGroupService);
        this.adStrategyGroupService=adStrategyGroupService;
    }

}

