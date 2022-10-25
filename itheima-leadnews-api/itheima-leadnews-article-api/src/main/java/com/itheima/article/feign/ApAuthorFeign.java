package com.itheima.article.feign;

import com.itheima.article.pojo.ApAuthor;
import com.itheima.common.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "leadnews-article",contextId = "apAuthorFeign")
public interface ApAuthorFeign {

    /**
     * 通过俩个id查询作者信息
     * @param apUserId
     * @param wmUserId
     * @return
     */
    @GetMapping("/api/apAuthor/getByApUserIdWmUserId/{apUserId}/{wmUserId}")
    ResultVo<ApAuthor> getByApUserIdWmUserId(@PathVariable(value = "apUserId") Long apUserId,
                                             @PathVariable(value = "wmUserId") Long wmUserId);

    /**
     * 添加作者
     * @param apAuthor
     * @return
     */
    @PostMapping("api/apAuthor/add")
    public ResultVo add(@RequestBody ApAuthor apAuthor);

}
