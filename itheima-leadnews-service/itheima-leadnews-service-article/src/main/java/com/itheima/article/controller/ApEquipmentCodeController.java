package com.itheima.article.controller;


import com.itheima.article.pojo.ApEquipmentCode;
import com.itheima.article.service.ApEquipmentCodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP设备码信息</p>
 *
 * @version 1.0
 * @package com.itheima.article.controller
 */
@Api(value="ApEquipmentCodeController",tags = "APP设备码信息")
@RestController
@RequestMapping("/apEquipmentCode")
public class ApEquipmentCodeController extends AbstractCoreController<ApEquipmentCode> {

    private ApEquipmentCodeService apEquipmentCodeService;

    @Autowired
    public ApEquipmentCodeController(ApEquipmentCodeService apEquipmentCodeService) {
        super(apEquipmentCodeService);
        this.apEquipmentCodeService=apEquipmentCodeService;
    }

}

