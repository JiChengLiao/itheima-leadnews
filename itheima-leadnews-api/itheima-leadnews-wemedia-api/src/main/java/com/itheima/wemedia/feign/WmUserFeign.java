package com.itheima.wemedia.feign;

import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.pojo.WmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "leadnews-wemedia",contextId = "wmUserFeign")
public interface WmUserFeign {

    /**
     * 通过apUserId查询自媒体账号信息
     * @param apUserId
     * @return
     */
    @GetMapping("/api/wmUser/getByApUserId/{apUserId}")
    ResultVo<WmUser> getByApUserId(@PathVariable(value = "apUserId") Long apUserId);

    /**
     * 添加自媒体账号
     * @param wmUser
     * @return
     */
    @PostMapping("/api/wmUser/add")
    ResultVo<WmUser> add(@RequestBody WmUser wmUser);
}
