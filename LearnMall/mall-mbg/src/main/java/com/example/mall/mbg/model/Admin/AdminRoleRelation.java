package com.example.mall.mbg.model.Admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Author saino
 * Create 11:05
 */
@Getter
@Setter
public class AdminRoleRelation {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "用户id")
    private Long adminId;
    @Schema(description = "角色id")
    private Long roleId;
}
