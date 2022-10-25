package com.itheima.article.controller;


import com.itheima.article.pojo.ApArticleLabel;
import com.itheima.article.service.ApArticleLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>文章标签信息</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApArticleLabelController",tags = "文章标签信息")
@RestController
@RequestMapping("/apArticleLabel")
public class ApArticleLabelController extends AbstractCoreController<ApArticleLabel> {

    private ApArticleLabelService apArticleLabelService;

    @Autowired
    public ApArticleLabelController(ApArticleLabelService apArticleLabelService) {
        super(apArticleLabelService);
        this.apArticleLabelService=apArticleLabelService;
    }

}

