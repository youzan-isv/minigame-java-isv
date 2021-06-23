package com.youzan.cloud.dy.api.service;

/**
 * @author chenlinghong
 * @date 2021-04-23 20:00
 *
 */
public interface OrderCallbackService {

    /**
     * 订购消息、授权消息
     */
    void message(String token);

    /**
     * 应用授权 code
     *
     * @param code
     */
    void code(String code);

}
