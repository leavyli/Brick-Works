package com.example.mall.admin.controller;

import com.example.mall.admin.dto.AdminDto;
import com.example.mall.admin.dto.AdminLogin;
import com.example.mall.admin.service.AdminService;
import com.example.mall.common.api.CommonResult;
import com.example.mall.mbg.mapper.Admin.AdminMapper;
import com.example.mall.mbg.model.Admin.Admin;
import com.nimbusds.jose.JOSEException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Author saino
 * LastModify 5:16
 * 后台管理Controller
 */
@Tag(name = "AdminController", description = "后台管理相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    private final AdminMapper adminMapper;


    /**
     * 注册用户
     *
     * @param adminDto 用户注册信息
     * @return CommonResult
     */
    @Operation(summary = "register user", description = "注册用户", tags = {"admin"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful response")}
    )
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<Admin> register(@Parameter(description = "注册用户", required = true) @Validated @RequestBody AdminDto adminDto) {
        Optional<Admin> u = adminService.register(adminDto);
        return u.map(CommonResult::success).orElseGet(CommonResult::failed);
    }

    /**
     * 登录以后返回token
     *
     * @param adminLogin 登录参数
     * @return jwt token
     */
    @Operation(summary = "user login", description = "用户登录", tags = "admin")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult<String> login(@Validated @RequestBody AdminLogin adminLogin) throws JOSEException {
        String token = adminService.login(adminLogin.getUsername(), adminLogin.getPassword());
        if (token == null) {
            return CommonResult.failed("用户名或密码错误");
        }

        return CommonResult.success(token, "登录成功");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public CommonResult<List<Admin>> test() {
        var ret = adminMapper.findAllAdminsByEmail("1233@gg.com");
        return CommonResult.success(ret);
//        return "JHello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "JHello";
    }

}
