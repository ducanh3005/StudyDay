package com.darly.api.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author:zhangyuhui
 * date:2020-05-2313:43
 * description: ApiValue 注解雷
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiValue {
    String value();
}
