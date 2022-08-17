package com.example.mall.mbg.model.Admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

/**
 * Author saino
 * LastModify 16:36
 */
@Getter
@Setter
public class Resource {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NonNull
    private Long adminId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "资源名称")
    private String name;

    @Schema(description = "资源URL")
    private String url;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "资源分类ID")
    private Long categoryId;
}
