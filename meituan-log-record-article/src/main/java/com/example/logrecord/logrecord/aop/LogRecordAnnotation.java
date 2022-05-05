package com.example.logrecord.logrecord.aop;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 9:34
 */
public @interface LogRecordAnnotation {
    String success();

    String fail() default "";

    String operator() default "";

    String bizNo();

    String category() default "";

    String detail() default "";

    String condition() default "";
}
