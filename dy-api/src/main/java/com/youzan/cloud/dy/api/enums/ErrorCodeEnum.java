package com.youzan.cloud.dy.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:56
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    SUCCESS(0, "Successful"),

    PARAM_ILLEGAL(-100, "非法参数"),

    ;

    private final int code;
    private final String message;
}
