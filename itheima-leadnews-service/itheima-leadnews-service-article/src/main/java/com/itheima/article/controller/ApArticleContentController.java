package com.itheima.article.controller;


import com.itheima.article.pojo.ApArticleContent;
import com.itheima.article.service.ApArticleContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP已发布文章内容</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApArticleContentController",tags = "APP已发布文章内容")
@RestController
@RequestMapping("/apArticleContent")
public class ApArticleContentController extends AbstractCoreController<ApArticleContent> {

    private ApArticleContentService apArticleContentService;

    @Autowired
    public ApArticleContentController(ApArticleContentService apArticleContentService) {
        super(apArticleContentService);
        this.apArticleContentService=apArticleContentService;
    }

}

