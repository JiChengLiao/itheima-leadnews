package com.itheima.wemedia.service;

import com.itheima.common.vo.PageResultVo;
import com.itheima.wemedia.dto.WmMaterialPageRequestDto;
import com.itheima.wemedia.pojo.WmMaterial;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @description <p>自媒体图文素材信息 业务接口</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.service
 */
public interface WmMaterialService extends IService<WmMaterial> {

    PageResultVo findPage(WmMaterialPageRequestDto dto);
}
