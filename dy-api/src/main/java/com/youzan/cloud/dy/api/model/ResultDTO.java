package com.youzan.cloud.dy.api.model;

import com.youzan.cloud.dy.api.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -2127990268830431098L;

    private Boolean success;
    private Integer code;
    private String message;

    private T data;

    public static <T> ResultDTO<T> success() {
        ResultDTO<T> result = new ResultDTO<>();
        result.setSuccess(true);
        result.setCode(0);
        result.setMessage("Successful");
        return result;
    }

    public static <T> ResultDTO<T> success(T data) {
        ResultDTO<T> result = success();
        result.setData(data);
        return result;
    }

    public static <T> ResultDTO<T> fail(ErrorCodeEnum errorCode) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setSuccess(false);
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        return result;
    }
}
