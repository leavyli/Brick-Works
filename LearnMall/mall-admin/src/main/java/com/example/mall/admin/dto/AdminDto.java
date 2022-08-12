package com.example.mall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Author saino
 * LastModify 13:15
 */
@Getter
@Setter
public class AdminDto {
//    @Schema(name = "username", description = "用户名", required = true)
    @NotBlank(message = "用户名不能为空白字符串")
    @Min(value = 4, message = "用户名长度不能小于4")
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
