package com.example.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mall.admin.dto.AdminDto;
import com.example.mall.admin.dto.AdminLogin;
import com.example.mall.admin.dto.UpdateUserRoleDto;
import com.example.mall.admin.service.AdminService;
import com.example.mall.admin.common.api.CommonResult;
import com.example.mall.admin.mapper.AdminMapper;
import com.example.mall.admin.model.Admin;
import com.example.mall.admin.model.Role;
import com.nimbusds.jose.JOSEException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author saino
 * LastModify 5:16
 * 后台管理Controller
 */
@Slf4j
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


    @Operation(summary = "get user by id", description = "通过id获取用户", tags = "admin")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @Cacheable(cacheNames = "userCache")
    public CommonResult<Admin> getUserById(@RequestParam(name = "userid") Long id) {
        log.debug("search no cache ");
        Admin user = adminService.getById(id);
        if (user != null) {
            return CommonResult.success(user);
        } else {
            return CommonResult.failed("sorry not has such user");
        }
    }

    @Operation(summary = "del user by id", description = "通过id删除用户", tags = "admin")
    @CacheEvict(cacheNames = "userCache")
    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public CommonResult<String> delUserById(@RequestParam(name = "userid") Long id) {
        var wrapper = new LambdaQueryWrapper<Admin>();
        wrapper.eq(Admin::getId, id);
        adminService.remove(wrapper);
        return CommonResult.success("删除成功");
    }

    @Operation(summary = "assigning roles to a user ", description = "给用户分配角色", tags = {"admin", "role"})
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public CommonResult<String> updateUserRole(@Validated @RequestBody UpdateUserRoleDto dto) {
        int count = adminService.updateRole(dto.getAdminId(), dto.getRoleIds());
        if (count >= 0) {
            return CommonResult.success("更新成功");
        }
        return CommonResult.failed("更新失败");
    }

    @Operation(summary = "get user's role list ", description = "获取用户被分配的角色", tags = {"admin", "role"})
    @RequestMapping(value = "/role/get", method = RequestMethod.GET)
    public CommonResult<List<Role>> getUserRole(@RequestParam("adminId") Long adminId) {
        List<Role> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
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
