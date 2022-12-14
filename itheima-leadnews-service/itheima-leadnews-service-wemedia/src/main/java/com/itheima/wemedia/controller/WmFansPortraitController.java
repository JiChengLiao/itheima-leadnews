package com.itheima.wemedia.controller;


import com.itheima.wemedia.pojo.WmFansPortrait;
import com.itheima.wemedia.service.WmFansPortraitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体粉丝画像信息</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmFansPortraitController",tags = "自媒体粉丝画像信息")
@RestController
@RequestMapping("/wmFansPortrait")
public class WmFansPortraitController extends AbstractCoreController<WmFansPortrait> {

    private WmFansPortraitService wmFansPortraitService;

    @Autowired
    public WmFansPortraitController(WmFansPortraitService wmFansPortraitService) {
        super(wmFansPortraitService);
        this.wmFansPortraitService=wmFansPortraitService;
    }

}

