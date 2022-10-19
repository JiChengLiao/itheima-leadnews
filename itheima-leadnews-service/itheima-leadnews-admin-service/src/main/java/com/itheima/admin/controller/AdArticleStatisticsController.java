package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdArticleStatistics;
import com.itheima.admin.service.AdArticleStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>文章数据统计</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdArticleStatisticsController",tags = "文章数据统计")
@RestController
@RequestMapping("/adArticleStatistics")
public class AdArticleStatisticsController extends AbstractCoreController<AdArticleStatistics> {

    private AdArticleStatisticsService adArticleStatisticsService;

    @Autowired
    public AdArticleStatisticsController(AdArticleStatisticsService adArticleStatisticsService) {
        super(adArticleStatisticsService);
        this.adArticleStatisticsService=adArticleStatisticsService;
    }

}

