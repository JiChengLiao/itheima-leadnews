package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdUserEquipment;
import com.itheima.admin.service.AdUserEquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>管理员设备信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdUserEquipmentController",tags = "管理员设备信息")
@RestController
@RequestMapping("/adUserEquipment")
public class AdUserEquipmentController extends AbstractCoreController<AdUserEquipment> {

    private AdUserEquipmentService adUserEquipmentService;

    @Autowired
    public AdUserEquipmentController(AdUserEquipmentService adUserEquipmentService) {
        super(adUserEquipmentService);
        this.adUserEquipmentService=adUserEquipmentService;
    }

}

