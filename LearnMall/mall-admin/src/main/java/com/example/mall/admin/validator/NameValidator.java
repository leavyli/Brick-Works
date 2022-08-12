package com.example.mall.admin.validator;

import com.example.mall.admin.validator.annation.NameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Author saino
 * LastModify 20:46
 */
public class NameValidator implements ConstraintValidator<NameConstraint,String> {
    @Override
    public void initialize(NameConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.contains("fuck")) {
            return false;
        } else {
            return true;
        }
    }
}
