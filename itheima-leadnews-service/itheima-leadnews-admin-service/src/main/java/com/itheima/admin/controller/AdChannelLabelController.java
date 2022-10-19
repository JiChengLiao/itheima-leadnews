package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdChannelLabel;
import com.itheima.admin.service.AdChannelLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>频道标签信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdChannelLabelController",tags = "频道标签信息")
@RestController
@RequestMapping("/adChannelLabel")
public class AdChannelLabelController extends AbstractCoreController<AdChannelLabel> {

    private AdChannelLabelService adChannelLabelService;

    @Autowired
    public AdChannelLabelController(AdChannelLabelService adChannelLabelService) {
        super(adChannelLabelService);
        this.adChannelLabelService=adChannelLabelService;

    }

}

