package com.example.mall.admin.validator.annation;

import com.example.mall.admin.validator.UserCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCheckConstraint {
    String message() default " user not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
