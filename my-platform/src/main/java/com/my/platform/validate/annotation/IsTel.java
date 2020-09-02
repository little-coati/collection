package com.my.platform.validate.annotation;

import com.my.platform.validate.validator.IsTelValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description: 手机号字段验证
 * @author: Karl
 * @date: 2020/9/2
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsTelValidator.class })
public @interface IsTel {
    String message() default "手机号码格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
