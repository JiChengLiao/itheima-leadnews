package com.itheima.article.controller;


import com.itheima.article.pojo.ApArticle;
import com.itheima.article.service.ApArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>已发布的文章信息</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApArticleController",tags = "已发布的文章信息")
@RestController
@RequestMapping("/apArticle")
public class ApArticleController extends AbstractCoreController<ApArticle> {

    private ApArticleService apArticleService;

    @Autowired
    public ApArticleController(ApArticleService apArticleService) {
        super(apArticleService);
        this.apArticleService=apArticleService;
    }

}

