package com.framework.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)

public @interface ConstructorAnnotatin {
    String constructorName() default "";
    String remark() default "构造器";
}
