package com.itheima.wemedia.controller;


import com.itheima.wemedia.pojo.WmNewsStatistics;
import com.itheima.wemedia.service.WmNewsStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体图文数据统计</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmNewsStatisticsController",tags = "自媒体图文数据统计")
@RestController
@RequestMapping("/wmNewsStatistics")
public class WmNewsStatisticsController extends AbstractCoreController<WmNewsStatistics> {

    private WmNewsStatisticsService wmNewsStatisticsService;

    @Autowired
    public WmNewsStatisticsController(WmNewsStatisticsService wmNewsStatisticsService) {
        super(wmNewsStatisticsService);
        this.wmNewsStatisticsService=wmNewsStatisticsService;
    }

}

