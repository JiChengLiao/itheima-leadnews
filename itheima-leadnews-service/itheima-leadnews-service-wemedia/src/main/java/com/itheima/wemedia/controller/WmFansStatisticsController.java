package com.itheima.wemedia.controller;


import com.itheima.wemedia.pojo.WmFansStatistics;
import com.itheima.wemedia.service.WmFansStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体粉丝数据统计</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmFansStatisticsController",tags = "自媒体粉丝数据统计")
@RestController
@RequestMapping("/wmFansStatistics")
public class WmFansStatisticsController extends AbstractCoreController<WmFansStatistics> {

    private WmFansStatisticsService wmFansStatisticsService;

    @Autowired
    public WmFansStatisticsController(WmFansStatisticsService wmFansStatisticsService) {
        super(wmFansStatisticsService);
        this.wmFansStatisticsService=wmFansStatisticsService;
    }

}

