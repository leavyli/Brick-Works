package com.example.mall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Author saino
 * Create 15:59
 */
@Setter
@Getter
@Builder
public class RoleDto {
    @NotEmpty
    private Long id;

    @Size(min = 1, max = 255, message = "名字1-255之间")
    @Pattern(regexp = "^\\w+$")
    @Schema(description = "名字")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "启用状态: 0->禁用； 1->启用")
    private Integer status;
//    private Integer sort;
}
