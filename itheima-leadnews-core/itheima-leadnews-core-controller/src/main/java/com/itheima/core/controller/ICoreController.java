package com.itheima.core.controller;

/**
 * @version 1.0
 * @description crud和分页查询
 * @package com.itheima.core.controller
 */
public interface ICoreController<T> extends
    ISelectController<T>,
    IInsertController<T>,
    IPagingController<T>,
    IDeleteController<T>,
    IUpdateController<T> {
}
