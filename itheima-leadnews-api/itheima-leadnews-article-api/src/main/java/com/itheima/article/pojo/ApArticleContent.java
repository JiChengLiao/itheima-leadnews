package com.itheima.article.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description <p>APP已发布文章内容 </p>
 *
 * @version 1.0
 * @package com.itheima.article.pojo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ap_article_content")
@ApiModel(value="ApArticleContent", description="APP已发布文章内容")
public class ApArticleContent implements Serializable {


    @ApiModelProperty(notes = "主键", dataType="Long")
    // IdType.INPUT 手工录入
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @ApiModelProperty(notes = "文章ID", dataType="Long")
    @TableField("article_id")
    private Long articleId;

    @ApiModelProperty(notes = "文章内容", dataType="String")
    @TableField("content")
    private String content;


}
