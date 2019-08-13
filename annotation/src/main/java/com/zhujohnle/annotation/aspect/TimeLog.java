package com.zhujohnle.annotation.aspect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Created by zhujohnle on 16/10/20.
 * 打印方法耗时Log注解，通过aop切片的方式在编译期间织入源代码中
 * 功能：自动打印方法的耗时
 **/
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface TimeLog {
}
