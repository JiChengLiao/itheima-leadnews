package com.itheima.admin.dto;

import com.itheima.common.dto.PageRequestDto;
import lombok.Data;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima.admin.dto
 */
@Data
public class ChannelPageRequestDto extends PageRequestDto {
    private String name;
    private Integer status;
}
