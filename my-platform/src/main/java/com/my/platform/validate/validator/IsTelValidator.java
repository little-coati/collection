package com.my.platform.validate.validator;

import com.my.platform.util.ValidatorUtil;
import com.my.platform.validate.annotation.IsTel;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 手机号码验证器
 * @author: Karl
 * @date: 2020/9/2
 */
public class IsTelValidator implements ConstraintValidator<IsTel,String> {
    @Override
    public void initialize(IsTel constraintAnnotation) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(value)) {
            return true;
        }else {
            return ValidatorUtil.isMobile(value);
        }
    }
}
