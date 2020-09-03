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
public class IsSex implements ConstraintValidator<Sex, String> {
    enum SexValue {
        DEFAULT("",""),
        MAN("0","男"),
        WOMAN("1","女"),
        TRANSGENDER("2","跨性别者");

        private String value;
        private String desc;

        private SexValue(String value,String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        /**
         * 匹配枚举项
         *
         * @param s 输入的字符串
         * @return 枚举项
         */
        public static SexValue matchSexValue(String s) {
            for (SexValue item : SexValue.values()) {
                if (item.getValue().equalsIgnoreCase(s)) {
                    return item;
                }
            }
            return DEFAULT;
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtil.isNullOrEmpty(s)) {
            return false;
        } else {
            switch (SexValue.matchSexValue(s)) {
                case MAN:
                case WOMAN:
                case TRANSGENDER:
                    return true;
                default:
                    return false;
            }
        }
    }
}
