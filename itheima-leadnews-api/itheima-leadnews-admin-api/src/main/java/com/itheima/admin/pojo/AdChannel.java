package com.itheima.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description <p>频道信息 </p>
 *
 * @version 1.0
 * @package com.itheima.admin.pojo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_channel")
@ApiModel(value="AdChannel", description="频道信息")
public class AdChannel implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(notes = "频道名称", dataType="String")
    @TableField("name")
    private String name;

    @ApiModelProperty(notes = "频道描述", dataType="String")
    @TableField("description")
    private String description;

    @ApiModelProperty(notes = "是否默认频道", dataType="Integer")
    @TableField("is_default")
    private Integer isDefault;

    @TableField("status")
    private Integer status;

    @ApiModelProperty(notes = "默认排序", dataType="Integer")
    @TableField("ord")
    private Integer ord;

    @ApiModelProperty(notes = "创建时间", dataType="LocalDateTime")
    @TableField("created_time")
    private LocalDateTime createdTime;


}
