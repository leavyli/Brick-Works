package com.example.javadesignpattern.facePattern.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Author saino
 * LastModify 17:10
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.METHOD)
public @interface DoDoor {
    String key() default "";
    String returnJson() default "";
}
