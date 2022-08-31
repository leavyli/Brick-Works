package com.example.mall.mbg.model.Admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Author saino
 * Create 2022/8/30 13:54
 */
@Getter
@Setter
@Builder
@ToString
public class Role {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "名词")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "后台用户数")
    private Integer adminCount;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "启用状态: 0->禁用； 1->启用")
    private Integer status;

    private Integer sort;

}
