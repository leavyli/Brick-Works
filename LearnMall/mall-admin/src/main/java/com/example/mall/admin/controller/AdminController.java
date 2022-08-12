package com.example.mall.admin.controller;

import com.example.mall.admin.dto.AdminDto;
import com.example.mall.common.api.CommonResult;
import com.example.mall.mbg.model.Admin.Admin;
import com.example.mall.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Author saino
 * LastModify 5:16
 * 后台管理Controller
 */
@Tag(name = "AdminController", description = "后台管理相关接口")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @Operation(summary = "register user", description = "注册用户", tags = {"Admin"})
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<Admin> register(@Validated @RequestBody AdminDto adminDto) {
        Optional<Admin> u = adminService.register(adminDto);
        return u.map(CommonResult::success).orElseGet(CommonResult::failed);
    }

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String  Hello(){
        return "JHello";
    }

}
