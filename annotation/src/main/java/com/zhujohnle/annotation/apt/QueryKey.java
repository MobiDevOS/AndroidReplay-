package com.zhujohnle.annotation.apt;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by zhujohnle on 17/1/25.
 */

@Retention(CLASS)
@Target(FIELD)
public @interface QueryKey {
}
