package com.itheima.controller;

import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.itheima.common.constants.BusinessConstants;
import com.itheima.common.constants.SystemConstants;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.util.RequestContextUtil;
import com.itheima.common.vo.ResultVo;
import com.itheima.wemedia.feign.WmMaterialFeign;
import com.itheima.wemedia.pojo.WmMaterial;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/dfs")
@Slf4j
@Api(tags = "文件管理")
public class FileController {

    @Resource
    private FastFileStorageClient client;

    @Resource
    private FdfsWebServer fdfsWebServer;

    @Resource
    private WmMaterialFeign wmMaterialFeign;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public ResultVo upload(MultipartFile multipartFile){

        //读取请求的来源，如果不是网关转发的，则报错
        String from = RequestContextUtil.getHeader(SystemConstants.USER_HEADER_FROM);
        if(StringUtils.isEmpty(from)){
            // 没有经过网关，没这个标识。
            throw new LeadNewsException("拒绝上传");
        }

        // 获取文件 后缀名， 【注意】不要.
        String filenameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        try {
            //上传文件
            StorePath storePath = client.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), filenameExtension, null);
            log.info("上传文件:{}", storePath.getFullPath());
            // 全路径，可以直接浏览器来访问
            String fullPath = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();

            //远程调用自媒体添加素材
            if(SystemConstants.WEMEDIA_PIC.equals(from)) {
                addWmMaterial(storePath.getFullPath());
            }

            /**
             * 返回 给前端的数据格式， 回显图片
             * {url:全路径}
             */
            // Collections.singletonMap 快速构建一个map, 且这个map只能有一个key
            return ResultVo.ok(Collections.singletonMap("url", fullPath));
        } catch (IOException e) {
            //e.printStackTrace();
            log.error("上传文件失败:{}", multipartFile.getOriginalFilename(),e);
            throw new LeadNewsException("上传文件失败，请稍后重试!");
        }

    }

    /**
     * 远程调用添加素材
     * @param fullPath
     */
    private void addWmMaterial(String fullPath) {
        //1. 构建pojo
        WmMaterial pojo = new WmMaterial();
        //2. 给pojo属性设置值
        pojo.setUrl(fullPath);
        // 报空指针：网关鉴权中没有把登录用户的id添加到请求头中。看自媒体网关AuthorizeFilter.filter方法
        pojo.setUserId(RequestContextUtil.getUserId());
        pojo.setCreatedTime(LocalDateTime.now());
        pojo.setIsCollection(0); // 新添加的素材，肯定不是收藏
        pojo.setType(0); // 素材类型为图片
        //3. 远程调用保存
        ResultVo resultVo = wmMaterialFeign.addWmmaterail(pojo);
        //4. 解析调用结果，如果失败则报错
        if(!resultVo.isSuccess()){
            log.error("远程调用自媒体，添加素材失败!: {}", resultVo.getErrorMessage());
            throw new LeadNewsException("上传素材失败");
        }
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.getFilenameExtension("abc.jpg"));
    }
}
