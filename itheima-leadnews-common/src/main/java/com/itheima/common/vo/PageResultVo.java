package com.itheima.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.common.vo
 */
@Data
@ApiModel(value="PageResultVo", description="通用分页响应结果")
public class PageResultVo<T> extends ResultVo<T> implements Serializable {
    @ApiModelProperty(notes = "页码", dataType="Long")
    private Long currentPage;
    @ApiModelProperty(notes = "每页大小", dataType="Long")
    private Long size;
    @ApiModelProperty(notes = "总记录数", dataType="Long")
    private Long total;


    /**
     * 快速构建分页结果
     * @param page  当前页
     * @param size  每页显示多少条
     * @param total 总共多少条
     * @param data  当前页的集合对象
     * @return
     */
    public static <T>PageResultVo<T> pageResult(Long page, Long size, Long total, List<T> data){
        PageResultVo vo = new PageResultVo();
        vo.setCurrentPage(page);
        vo.setSize(size);
        vo.setTotal(total);
        vo.setData(data);
        return vo;
    }
}
