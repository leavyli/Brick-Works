package com.example.mall.admin.dto;

import com.example.mall.admin.validator.annation.UserCheckConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Author saino
 * Create 14:14
 */
@Getter
@Setter
public class UpdateUserRoleDto {
    @NotNull(message = "must not null")
    @UserCheckConstraint
    private Long adminId;
    @NotNull(message = "must not null")
    private List<Long> roleIds;
}
