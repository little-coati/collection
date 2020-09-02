package com.my.platform.validate.validator;

import com.my.common.util.StringUtil;
import com.my.platform.validate.annotation.Sex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 性别枚举验证
 * @author: Karl
 * @date: 2020/9/2
 */
public class IsSex implements ConstraintValidator<Sex,String> {
    private final String man = "0";
    private final String woman = "1";
    private final String transgender = "2";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtil.isNullOrEmpty(s)) {
            return false;
        } else {
            switch (s) {
                case man:
                case woman:
                case transgender:
                    return true;
                default:
                    return false;
            }
        }
    }
}
