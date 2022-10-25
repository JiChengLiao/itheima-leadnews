package com.itheima.article.controller;


import com.itheima.article.pojo.ApAssociateWords;
import com.itheima.article.service.ApAssociateWordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>联想词</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApAssociateWordsController",tags = "联想词")
@RestController
@RequestMapping("/apAssociateWords")
public class ApAssociateWordsController extends AbstractCoreController<ApAssociateWords> {

    private ApAssociateWordsService apAssociateWordsService;

    @Autowired
    public ApAssociateWordsController(ApAssociateWordsService apAssociateWordsService) {
        super(apAssociateWordsService);
        this.apAssociateWordsService=apAssociateWordsService;
    }

}

