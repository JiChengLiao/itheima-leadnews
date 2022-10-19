package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdChannel;
import com.itheima.admin.service.AdChannelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>频道信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdChannelController",tags = "频道信息")
@RestController
@RequestMapping("/adChannel")
public class AdChannelController extends AbstractCoreController<AdChannel> {

    private AdChannelService adChannelService;

    @Autowired
    public AdChannelController(AdChannelService adChannelService) {
        super(adChannelService);
        this.adChannelService=adChannelService;
    }

}

