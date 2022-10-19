package com.itheima.admin.controller;


import com.itheima.admin.pojo.AdSensitive;
import com.itheima.admin.service.AdSensitiveService;
import com.itheima.common.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @description <p>敏感词信息</p>
 *
 * @version 1.0
 * @package com.itheima.admin.controller
 */
@Api(value="AdSensitiveController",tags = "敏感词信息")
@RestController
@RequestMapping("/adSensitive")
public class AdSensitiveController extends AbstractCoreController<AdSensitive> {

    private AdSensitiveService adSensitiveService;

    @Autowired
    public AdSensitiveController(AdSensitiveService adSensitiveService) {
        super(adSensitiveService);
        this.adSensitiveService=adSensitiveService;
    }

    @Override
    public ResultVo<AdSensitive> insert(AdSensitive record) {

        Date todayDate = new Date();

        LocalDateTime ldt = todayDate.toInstant()
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();
        record.setCreatedTime(ldt);
        return super.insert(record);
    }
}

