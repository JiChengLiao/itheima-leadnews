package com.itheima.article.controller;


import com.itheima.article.pojo.ApEquipment;
import com.itheima.article.service.ApEquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP设备信息</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApEquipmentController",tags = "APP设备信息")
@RestController
@RequestMapping("/apEquipment")
public class ApEquipmentController extends AbstractCoreController<ApEquipment> {

    private ApEquipmentService apEquipmentService;

    @Autowired
    public ApEquipmentController(ApEquipmentService apEquipmentService) {
        super(apEquipmentService);
        this.apEquipmentService=apEquipmentService;
    }

}

