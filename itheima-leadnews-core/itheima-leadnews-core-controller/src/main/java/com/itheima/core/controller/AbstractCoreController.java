package com.itheima.core.controller;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.common.dto.PageRequestDto;
import com.itheima.common.vo.PageResultVo;
import com.itheima.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.core.controller
 */
public abstract class AbstractCoreController<T> implements ICoreController<T> {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(AbstractCoreController.class);
    //调用方的service
    protected IService<T> coreService;

    public AbstractCoreController(IService<T> coreService) {
        this.coreService = coreService;
    }

    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    @Override
    @ApiOperation("通过Id删除")
    public ResultVo deleteById(@PathVariable(name = "id") Serializable id) {
        boolean flag = coreService.removeById(id);
        if (!flag) {
            return ResultVo.error();
        }
        return ResultVo.ok();
    }

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    @PostMapping("/save")
    @Override
    @ApiOperation("新增")
    public ResultVo<T> insert(@RequestBody T record) {
        boolean flag = coreService.save(record);
        if (!flag) {
            return ResultVo.error();
        }
        return ResultVo.ok(record);
    }

    /**
     * 更新数据
     *
     * @param record
     * @return
     */
    @Override
    @PostMapping("/update")
    @ApiOperation("通过Id更新")
    public ResultVo updateByPrimaryKey(@RequestBody T record) {
        boolean flag = coreService.updateById(record);
        if (!flag) {
            return ResultVo.error();
        }
        return ResultVo.ok();
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("/{id}")
    @ApiOperation("通过Id查询")
    public ResultVo<T> findById(@PathVariable(name = "id") Serializable id) {
        T t = coreService.getById(id);
        return ResultVo.ok(t);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    @GetMapping
    @ApiOperation("查询所有")
    public ResultVo<List<T>> findAll() {
        List<T> list = coreService.list();
        return ResultVo.ok(list);
    }

    //根据条件查询       这个需要用到反射  select * from 表（泛型） where  ?=? and ?=?
    @Override
    @PostMapping("/listCondition")
    @ApiOperation("条件查询所有")
    public ResultVo<List<T>> findByRecord(@RequestBody T record) {
        QueryWrapper<T> queryWrapper = getWrapper(record,false);
        List<T> list = coreService.list(queryWrapper);
        return ResultVo.ok(list);
    }

    /**
     * 根据查询条件 requestDto 分页查询
     *
     * @param dto
     * @return
     */
    @Override
    public PageResultVo findByPage(PageRequestDto dto) {
        IPage pageParam = new Page(dto.getPage(),dto.getSize());
        IPage pageInfo = coreService.page(pageParam);
        return PageResultVo.pageResult(dto.getPage(),dto.getSize(), pageInfo.getTotal(), pageInfo.getRecords());
    }

    public QueryWrapper<T> getWrapper(T condition, boolean stringAsLike) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (condition == null) {
            return queryWrapper;
        }
        Class<?> cls = condition.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                //遇到 id注解 则直接跳过 不允许实现根据主键查询
                if (field.isAnnotationPresent(TableId.class) || field.getName().equals("serialVersionUID")) {
                    //遇到
                    continue;
                }
                //属性描述器  record.getClass()
                PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(cls,field.getName());
                //获取这个值  先获取读方法的方法对象,并调用获取里面的值
                Object value = propertyDescriptor.getReadMethod().invoke(condition);
                //如果是字符串
                TableField annotation = field.getAnnotation(TableField.class);
                //如果传递的值为空则不做处理
                if (value != null) {
                    //如是字符串 则用like
                    if ("java.lang.String".equals(value.getClass().getName()) && stringAsLike) {
                        queryWrapper.like(annotation.value(), value);
                    } else {
                        //否则使用=号
                        queryWrapper.eq(annotation.value(), value);
                    }
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e2) {
            logger.error("属性读取失败！", e2);
        }
        return queryWrapper;
    }
}
