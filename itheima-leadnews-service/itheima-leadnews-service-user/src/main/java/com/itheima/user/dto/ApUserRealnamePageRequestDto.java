package com.itheima.user.dto;

import com.itheima.common.dto.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.user.dto
 */
@Data
@ApiModel(description = "实名认证分页查询条件",value = "apUserRealnamePageRequestDto")
public class ApUserRealnamePageRequestDto extends PageRequestDto {
    @ApiModelProperty(notes = "审核的状态", dataType = "Integer")
    private Integer status;
}