package com.example.logrecord.logrecord.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 9:25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {
    @AliasFor("value")
    String content() default "";
    @AliasFor("content")
    String value()  default "";
}
