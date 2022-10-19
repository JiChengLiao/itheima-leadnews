package com.itheima.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ApiModel(value="PageRequestDto", description="通用分页查询参数")
public class PageRequestDto {
    @ApiModelProperty(notes = "每页大小", dataType="Long")
    private Long size;
    @ApiModelProperty(notes = "页码", dataType="Long")
    private Long page;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1l);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10l);
        }
    }
}
