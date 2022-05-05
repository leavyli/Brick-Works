package com.example.jdkproxydemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/5 13:53
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomTransaction {
    String value() default "default MyTransaction";
}


