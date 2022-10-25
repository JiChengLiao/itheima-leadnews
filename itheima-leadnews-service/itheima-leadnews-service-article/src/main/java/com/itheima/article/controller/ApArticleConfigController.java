package com.itheima.article.controller;


import com.itheima.article.pojo.ApArticleConfig;
import com.itheima.article.service.ApArticleConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP已发布文章配置</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApArticleConfigController",tags = "APP已发布文章配置")
@RestController
@RequestMapping("/apArticleConfig")
public class ApArticleConfigController extends AbstractCoreController<ApArticleConfig> {

    private ApArticleConfigService apArticleConfigService;

    @Autowired
    public ApArticleConfigController(ApArticleConfigService apArticleConfigService) {
        super(apArticleConfigService);
        this.apArticleConfigService=apArticleConfigService;
    }

}

