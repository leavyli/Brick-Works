package com.example.justJSR269.annotation.source;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.SOURCE)
public @interface NoArgsConstructor {
}
