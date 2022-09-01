package com.example.mall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Author saino
 * Create 15:59
 */
@Setter
@Getter
public class RoleDto {
    @Size(min = 1, max = 255, message = "名字1-255之间")
    @Pattern(regexp = "^\\w+$", message = "角色名字只能为英文字符")
    @Schema(description = "名字")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "启用状态: 0->禁用； 1->启用")
    private Integer status;
//    private Integer sort;
}
