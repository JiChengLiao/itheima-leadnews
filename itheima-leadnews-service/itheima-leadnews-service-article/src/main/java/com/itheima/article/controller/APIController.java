package com.itheima.article.controller;

import com.itheima.article.pojo.ApAuthor;
import com.itheima.article.service.ApAuthorService;
import com.itheima.common.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class APIController {
    @Resource
private ApAuthorService apAuthorService;


    @GetMapping("/api/apAuthor/getByApUserIdWmUserId/{apUserId}/{wmUserId}")
    public ResultVo<ApAuthor> getByApUserIdWmUserId(@PathVariable(value = "apUserId") Long apUserId,
                                                    @PathVariable(value = "wmUserId") Long wmUserId){
        ApAuthor author = apAuthorService.getByApUserIdAndWmUserId(apUserId,wmUserId);
        return ResultVo.ok(author);
    }

    /**
     * 添加作者
     * @param apAuthor
     * @return
     */
    @PostMapping("api/apAuthor/add")
    public ResultVo add(@RequestBody ApAuthor apAuthor){

   apAuthorService.save(apAuthor);
   return ResultVo.ok();
    }
}
