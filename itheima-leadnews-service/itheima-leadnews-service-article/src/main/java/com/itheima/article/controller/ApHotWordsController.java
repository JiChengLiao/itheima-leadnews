package com.itheima.article.controller;


import com.itheima.article.pojo.ApHotWords;
import com.itheima.article.service.ApHotWordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>搜索热词</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApHotWordsController",tags = "搜索热词")
@RestController
@RequestMapping("/apHotWords")
public class ApHotWordsController extends AbstractCoreController<ApHotWords> {

    private ApHotWordsService apHotWordsService;

    @Autowired
    public ApHotWordsController(ApHotWordsService apHotWordsService) {
        super(apHotWordsService);
        this.apHotWordsService=apHotWordsService;
    }

}

