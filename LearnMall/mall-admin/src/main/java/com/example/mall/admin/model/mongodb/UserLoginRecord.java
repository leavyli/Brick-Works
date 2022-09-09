package com.example.mall.admin.model.mongodb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Author saino
 * Create 2022/9/9 10:33
 */
@Setter
@Getter
@Document(collection = "UserLoginRecord")
@ToString
public class UserLoginRecord {
    @Setter(AccessLevel.NONE)
    private String id;
    @Schema(description = "用户名字")
    private String userName;
    @Schema(description = "是否登录成功")
    private Boolean success;

    @Schema(description = "登录时间")
    private LocalDateTime loginTime;

    @Builder
    public UserLoginRecord(String userName,  Boolean success, LocalDateTime loginTime) {
        this.userName = userName;
        this.success = success;
        this.loginTime = loginTime;
    }

}
