package com.my.platform.validate.annotation;

import com.my.platform.validate.validator.IsSex;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description: 性别字段枚举验证
 * @author: Karl
 * @date: 2020/9/2
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsSex.class })
public @interface Sex {
    String message() default "性别枚举项传参错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
