package com.itheima.wemedia.dto;

import com.itheima.common.dto.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.wemedia.dto
 */
@Data
@ApiModel(value = "WmMaterialPageRequestDto", description = "素材分页查询条件")
public class WmMaterialPageRequestDto extends PageRequestDto {
    /**
     * 是否是收藏
     */
    @ApiModelProperty(notes = "是否是收藏", dataType = "Integer")
    private Integer isCollection;
}