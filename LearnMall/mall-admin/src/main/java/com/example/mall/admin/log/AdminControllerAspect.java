package com.example.mall.admin.log;

import com.example.mall.admin.common.api.CommonResult;
import com.example.mall.admin.dto.AdminLogin;
import com.example.mall.admin.model.mongodb.UserLoginRecord;
import com.example.mall.admin.repository.mongodb.UserLoginRecordRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Author saino
 * Create 2022/9/7 12:31
 */
@Aspect
@Component
@RequiredArgsConstructor
public class AdminControllerAspect {
    private final UserLoginRecordRepository userLoginRecordRepository;

    @Pointcut("execution(public * com.example.mall.admin.controller.AdminController.*(..))")
    public void webLog() {
    }

    @Pointcut("execution(public * com.example.mall.admin.controller.AdminController.login(..))")
    public void logIn() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturn(Object ret) {

    }


    @Around("logIn() && args(adminLogin, ..)")
    public Object doLogInAround(ProceedingJoinPoint joinPoint, AdminLogin adminLogin) throws Throwable {
        var u = UserLoginRecord.builder();
        u.userName(adminLogin.getUsername());
        u.loginTime(LocalDateTime.now());

        Object result = joinPoint.proceed();
        var r = (CommonResult) result;
        if (r.getData() != null) {
            u.success(true);
        } else {
            u.success(false);
        }

        userLoginRecordRepository.insert(u.build());
        return result;
    }



}
