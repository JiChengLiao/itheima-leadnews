package com.itheima.wemedia.controller;

import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.pojo.WmMaterial;
import com.itheima.wemedia.pojo.WmUser;
import com.itheima.wemedia.service.WmMaterialService;
import com.itheima.wemedia.service.WmUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ApiController {

    @Resource
    private WmUserService wmUserService;

    @Resource
    private WmMaterialService wmMaterialService;

    @GetMapping("/api/wmUser/getByApUserId/{apUserId}")
    public ResultVo<WmUser> getByApUserId(@PathVariable(value = "apUserId") Long apUserId){
        WmUser wmUser = wmUserService.getByApUserId(apUserId);
        return ResultVo.ok(wmUser);
    }

    /**
     * 添加自媒体账号
     * @param wmUser
     * @return
     */
    @PostMapping("/api/wmUser/add")
    public ResultVo<WmUser> addWmUser(@RequestBody WmUser wmUser){
        wmUserService.save(wmUser);
        return ResultVo.ok(wmUser);
    }
    /**
     * 远程调用接口
     * @param wmMaterial
     * @return
     */
    @PostMapping("/api/wmMaterial/add")
    public ResultVo addWmmaterail(@RequestBody WmMaterial wmMaterial){
         wmMaterialService.save(wmMaterial);
        return ResultVo.ok("添加成功");

    }
}
