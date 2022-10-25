package com.itheima.wemedia.controller;


import com.itheima.common.vo.PageResultVo;
import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.dto.WmMaterialPageRequestDto;
import com.itheima.wemedia.pojo.WmMaterial;
import com.itheima.wemedia.service.WmMaterialService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>自媒体图文素材信息</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.controller
 */
@Api(value="WmMaterialController",tags = "自媒体图文素材信息")
@RestController
@RequestMapping("/material")
public class WmMaterialController extends AbstractCoreController<WmMaterial> {

    private WmMaterialService wmMaterialService;

    @Autowired
    public WmMaterialController(WmMaterialService wmMaterialService) {
        super(wmMaterialService);
        this.wmMaterialService=wmMaterialService;
    }

    /**
     * 素材分页查询
     * @param dto
     * @return
     */
    @PostMapping("/list")
    public PageResultVo findPage(@RequestBody WmMaterialPageRequestDto dto){

     PageResultVo vo=wmMaterialService.findPage(dto);
     return vo;

    }
    
    @GetMapping("/del_picture/{id}")
    public ResultVo delete(@PathVariable (value = "id")Long id){
    
    wmMaterialService.removeById(id);
    return ResultVo.ok("操作成功");
    
    }

}

