package com.itheima.core.controller;

import com.itheima.common.dto.PageRequestDto;
import com.itheima.common.vo.PageResultVo;

/**
 * @version 1.0
 * @description 标题
 * @package com.itheima.core.controller
 */
public interface IPagingController<T> {

    /**
     * 根据查询条件 dto 分页查询
     * @return
     */
    PageResultVo findByPage(PageRequestDto dto);
}
