package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdRecommendStrategy;
import com.itheima.admin.service.AdRecommendStrategyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>推荐策略信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdRecommendStrategyController",tags = "推荐策略信息")
@RestController
@RequestMapping("/adRecommendStrategy")
public class AdRecommendStrategyController extends AbstractCoreController<AdRecommendStrategy> {

    private AdRecommendStrategyService adRecommendStrategyService;

    @Autowired
    public AdRecommendStrategyController(AdRecommendStrategyService adRecommendStrategyService) {
        super(adRecommendStrategyService);
        this.adRecommendStrategyService=adRecommendStrategyService;
    }

}

