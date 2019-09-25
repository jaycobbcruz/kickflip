package com.jaycobb.kickflip.common.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EntityField {

    /**
     * Mark entity property as read-only.
     * If true, model property will not be updated.
     */
    boolean readOnly() default false;

    /**
     * Entity property name.
     */
    String entityProperty() default "";

    Class<?> type() default String.class;

}
