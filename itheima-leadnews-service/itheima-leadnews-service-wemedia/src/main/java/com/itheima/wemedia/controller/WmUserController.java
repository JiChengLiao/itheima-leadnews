package com.itheima.wemedia.controller;


import com.itheima.common.util.RequestContextUtil;
import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.pojo.WmUser;
import com.itheima.wemedia.service.WmUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

import javax.xml.transform.Result;

/**
 * @description <p>自媒体用户信息</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmUserController",tags = "自媒体用户信息")
@RestController
@RequestMapping("/wmUser")
public class WmUserController extends AbstractCoreController<WmUser> {

    private WmUserService wmUserService;

    @Autowired
    public WmUserController(WmUserService wmUserService) {
        super(wmUserService);
        this.wmUserService=wmUserService;
    }

    @GetMapping("getLoginUserId")
    public ResultVo getLoginUserId(){
        Long userId = RequestContextUtil.getUserId();
        return ResultVo.ok(userId);
    }

}

