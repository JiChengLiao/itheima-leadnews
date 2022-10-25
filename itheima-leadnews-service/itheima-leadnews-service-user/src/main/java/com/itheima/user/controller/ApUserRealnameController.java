package com.itheima.user.controller;


import com.itheima.common.vo.PageResultVo;
import com.itheima.common.vo.ResultVo;
import com.itheima.user.dto.ApUserRealnamePageRequestDto;
import com.itheima.user.pojo.ApUserRealname;
import com.itheima.user.service.ApUserRealnameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

import java.util.Map;

/**
 * @description <p>APP实名认证信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserRealnameController",tags = "APP实名认证信息")
@RestController
@RequestMapping("/auth")
public class ApUserRealnameController extends AbstractCoreController<ApUserRealname> {

    private ApUserRealnameService apUserRealnameService;

    @Autowired
    public ApUserRealnameController(ApUserRealnameService apUserRealnameService) {
        super(apUserRealnameService);
        this.apUserRealnameService=apUserRealnameService;
    }

    @PostMapping("/list")
    @ApiOperation("分页查询")
    public PageResultVo pagelist (@RequestBody ApUserRealnamePageRequestDto dto){
    PageResultVo vo=apUserRealnameService.findpage(dto);
    return vo;
    
    }

    /**
     * 审核通过
     * @param paramMap
     * @return
     */
    @PostMapping("/authPass")
    public ResultVo authpass(@RequestBody Map<String,Object>paramMap){
    
    apUserRealnameService.authpass(paramMap);
    return ResultVo.ok("操作成功");
    }

    /**
     * 审核驳回
     *
     * @param paramMap
     * @return
     */
    @PostMapping("/authFail")
    public ResultVo authFail(@RequestBody Map<String, Object> paramMap) {

        apUserRealnameService.authFail(paramMap);
        return ResultVo.ok("操作成功");
    }





}

