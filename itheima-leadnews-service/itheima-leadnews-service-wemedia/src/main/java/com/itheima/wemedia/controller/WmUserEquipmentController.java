package com.itheima.wemedia.controller;


import com.itheima.wemedia.pojo.WmUserEquipment;
import com.itheima.wemedia.service.WmUserEquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体用户设备信息</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmUserEquipmentController",tags = "自媒体用户设备信息")
@RestController
@RequestMapping("/wmUserEquipment")
public class WmUserEquipmentController extends AbstractCoreController<WmUserEquipment> {

    private WmUserEquipmentService wmUserEquipmentService;

    @Autowired
    public WmUserEquipmentController(WmUserEquipmentService wmUserEquipmentService) {
        super(wmUserEquipmentService);
        this.wmUserEquipmentService=wmUserEquipmentService;
    }

}

