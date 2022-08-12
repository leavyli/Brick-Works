package com.example.mall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * Author saino
 * LastModify 21:11
 */
@Getter
@Setter
public class AdminLogin {
    @NotEmpty
    @Schema(name = "username", description = "用户名", required = true)
    private String username;
    @NotEmpty
    @Schema(name = "password", description = "密码", required = true)
    private String password;
}
