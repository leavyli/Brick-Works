package com.example.mall.admin.validator.annation;

import com.example.mall.admin.validator.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "not invalid name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
