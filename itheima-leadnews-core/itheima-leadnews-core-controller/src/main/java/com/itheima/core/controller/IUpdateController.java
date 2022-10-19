package com.itheima.core.controller;

import com.itheima.common.vo.ResultVo;

/**
 * @version 1.0
 * @description 标题
 * @package com.itheima.core.controller
 */
public interface IUpdateController<T> {

    /**
     * 根据对象进行更新 根据ID
     *
     * @param record
     * @return
     */
    ResultVo updateByPrimaryKey(T record);
}
