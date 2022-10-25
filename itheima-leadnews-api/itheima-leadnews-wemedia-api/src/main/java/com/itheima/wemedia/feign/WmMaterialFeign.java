package com.itheima.wemedia.feign;

import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.pojo.WmMaterial;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="leadnews-wemedia",contextId = "WmMaterialFeign")
public interface WmMaterialFeign {
    /**
     * 远程调用接口
     * @param wmMaterial
     * @return
     */
    @PostMapping("/api/wmMaterial/add")
    public ResultVo addWmmaterail(@RequestBody WmMaterial wmMaterial);
    
}
