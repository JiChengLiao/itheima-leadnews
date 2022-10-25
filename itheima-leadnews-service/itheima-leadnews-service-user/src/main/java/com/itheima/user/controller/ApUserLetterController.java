package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserLetter;
import com.itheima.user.service.ApUserLetterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户私信信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserLetterController",tags = "APP用户私信信息")
@RestController
@RequestMapping("/apUserLetter")
public class ApUserLetterController extends AbstractCoreController<ApUserLetter> {

    private ApUserLetterService apUserLetterService;

    @Autowired
    public ApUserLetterController(ApUserLetterService apUserLetterService) {
        super(apUserLetterService);
        this.apUserLetterService=apUserLetterService;
    }

}

