package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserFan;
import com.itheima.user.service.ApUserFanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户粉丝信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserFanController",tags = "APP用户粉丝信息")
@RestController
@RequestMapping("/apUserFan")
public class ApUserFanController extends AbstractCoreController<ApUserFan> {

    private ApUserFanService apUserFanService;

    @Autowired
    public ApUserFanController(ApUserFanService apUserFanService) {
        super(apUserFanService);
        this.apUserFanService=apUserFanService;
    }

}

