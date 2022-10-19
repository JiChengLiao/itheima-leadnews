package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdLabel;
import com.itheima.admin.service.AdLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>标签信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdLabelController",tags = "标签信息")
@RestController
@RequestMapping("/adLabel")
public class AdLabelController extends AbstractCoreController<AdLabel> {

    private AdLabelService adLabelService;

    @Autowired
    public AdLabelController(AdLabelService adLabelService) {
        super(adLabelService);
        this.adLabelService=adLabelService;
    }

}

