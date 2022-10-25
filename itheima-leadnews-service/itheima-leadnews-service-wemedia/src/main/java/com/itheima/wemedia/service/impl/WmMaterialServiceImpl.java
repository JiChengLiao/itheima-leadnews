package com.itheima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.common.util.RequestContextUtil;
import com.itheima.common.vo.PageResultVo;
import com.itheima.wemedia.dto.WmMaterialPageRequestDto;
import com.itheima.wemedia.pojo.WmMaterial;
import com.itheima.wemedia.mapper.WmMaterialMapper;
import com.itheima.wemedia.service.WmMaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.text.CollatorUtilities;

import java.util.List;

/**
 * @description <p>自媒体图文素材信息 业务实现</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.service.impl
 */
@Service
public class WmMaterialServiceImpl extends ServiceImpl<WmMaterialMapper, WmMaterial> implements WmMaterialService {

    @Value("${fastdfs-server}")
    private String fdfsWbServerurl;

    /**
     * 分页展示图片
     * @param dto
     * @return
     */
    @Override
    public PageResultVo findPage(WmMaterialPageRequestDto dto) {
       //1设置分页参数
        IPage<WmMaterial>pageInfo=new Page<>(dto.getPage(),dto.getSize());
        //2创建条件
        LambdaQueryWrapper<WmMaterial>lqw=new LambdaQueryWrapper<>();

        //3分页查询
        lqw.eq(WmMaterial::getUserId, RequestContextUtil.getUserId());
        //4不全路径
        lqw.eq(dto.getIsCollection()!=0,WmMaterial::getIsCollection,dto.getIsCollection());
        //封装放回
        page(pageInfo,lqw);
        List<WmMaterial> records = pageInfo.getRecords();
        if (!CollectionUtils.isEmpty(records)){

            //for (WmMaterial record : records) {
            //    record.setUrl(fdfsWbServerurl+record.getUrl());
            //}

        records.forEach(m->m.setUrl(fdfsWbServerurl+m.getUrl()));
        }

        return PageResultVo.pageResult(dto.getPage(),dto.getSize(),pageInfo.getTotal(),records);
    }
}
