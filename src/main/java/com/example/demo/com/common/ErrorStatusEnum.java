package com.example.demo.com.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.UnknownFormatFlagsException;

/**
 * <p>
 * 状态枚举
 * </p>
 *
 */
public enum ErrorStatusEnum {
    //
    REGISTER(402, "请注册"),
    NO_ACCESS(403, "无权限查看或编辑"),
    PARAM_NULL(601, "参数为空！"),
    PARAM_ANY_NULL(602, "个别参数值为空！"),
    NO_LOGIN(1002, "请登录"),
    CAPTCHA_ERROR(2000, "短信验证码错误"),
    ID_NOT_EXIST(2001, "ID不存在！");

    @EnumValue
    private final int value;
    private final String desc;

    ErrorStatusEnum(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return this.value;
    }

    @JsonValue
	public String getDesc() {
		return desc;
	}
	 @JsonCreator
    public static ErrorStatusEnum getEnum(int value) {
        for (ErrorStatusEnum enums : ErrorStatusEnum.values()) {
            if (enums.getValue() == value) {
                return enums;
            }
        }
        throw new UnknownFormatFlagsException("Error: Invalid Enum type value: " + value);
    }
}
