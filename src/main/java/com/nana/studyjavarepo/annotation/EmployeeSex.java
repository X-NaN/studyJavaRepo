package com.nana.studyjavarepo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解-员工性别
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeSex {
    enum Sex{Man,Woman}
    Sex employeeSex() default Sex.Man;
}
