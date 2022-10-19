package com.itheima.admin.dto;

import com.itheima.common.dto.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.admin.dto
 */
@Data
@ApiModel("敏感词分页查询条件")
public class SensitivePageRequestDto extends PageRequestDto {
    @ApiModelProperty("敏感词查询条件")
    private String name;



}
