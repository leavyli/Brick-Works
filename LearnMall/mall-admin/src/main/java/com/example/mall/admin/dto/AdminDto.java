package com.example.mall.admin.dto;

import com.example.mall.admin.validator.annation.NameConstraint;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Author saino
 * LastModify 13:15
 */
@Getter
@Setter
public class AdminDto {
    @Size(min = 4, max = 20, message = "用户名长度必须在4-20之间")
    @Schema(name = "username", description = "用户名", required = true)
    private String username;
    @NotEmpty
    @Schema(name = "password", description = "密码", required = true)
    private String password;
    @Schema(name = "icon", description = "用户头像")
    private String icon;
    @Email
    @Schema(name = "email", description = "邮箱")
    private String email;
    @Schema(name = "nickName", description = "用户昵称")
    private String nickName;
    @Schema(name = "note",description = "备注")
    private String note;

}
