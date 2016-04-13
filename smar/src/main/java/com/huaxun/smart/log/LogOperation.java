package com.huaxun.smart.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//被JVM保留
@Target(ElementType.METHOD)//scope def
public @interface LogOperation {
    String action();
}
