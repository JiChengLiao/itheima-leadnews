package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserEquipment;
import com.itheima.user.service.ApUserEquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户设备信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserEquipmentController",tags = "APP用户设备信息")
@RestController
@RequestMapping("/apUserEquipment")
public class ApUserEquipmentController extends AbstractCoreController<ApUserEquipment> {

    private ApUserEquipmentService apUserEquipmentService;

    @Autowired
    public ApUserEquipmentController(ApUserEquipmentService apUserEquipmentService) {
        super(apUserEquipmentService);
        this.apUserEquipmentService=apUserEquipmentService;
    }

}

