package com.example.mall.admin.validator;

import com.example.mall.admin.service.AdminService;
import com.example.mall.admin.validator.annation.UserCheckConstraint;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Author saino
 * Create 14:37
 */
@RequiredArgsConstructor
public class UserCheckValidator implements ConstraintValidator<UserCheckConstraint, Long> {
    private final AdminService adminService;

    @Override
    public void initialize(UserCheckConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        var ret = adminService.getById(value);
        return ret != null;
    }
}
