package com.itheima.article.controller;


import com.itheima.article.pojo.ApCollection;
import com.itheima.article.service.ApCollectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP收藏信息</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApCollectionController",tags = "APP收藏信息")
@RestController
@RequestMapping("/apCollection")
public class ApCollectionController extends AbstractCoreController<ApCollection> {

    private ApCollectionService apCollectionService;

    @Autowired
    public ApCollectionController(ApCollectionService apCollectionService) {
        super(apCollectionService);
        this.apCollectionService=apCollectionService;
    }

}

