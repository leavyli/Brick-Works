package com.example.mall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Author saino
 * Create 2022/9/5 18:06
 */
@Getter
@Setter
public class AssignRoleResourcesDto {
    @NotNull
    @Schema(description = "角色ID")
    private Long roleId;
    @NotNull
    @Schema(description = "资源ID列表")
    private List<Long> resourceIds;
}
