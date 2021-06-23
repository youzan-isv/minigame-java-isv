package com.youzan.cloud.dy.biz.component;

import com.alibaba.fastjson.JSON;
import com.youzan.cloud.dy.api.model.callback.OrderCallbackMessage;

import com.youzan.cloud.dy.biz.config.ApplicationConfig;
import com.youzan.cloud.dy.biz.utils.AESUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import java.net.URLDecoder;

/**
 * @author chenlinghong
 * @date 2021-04-23 20:20
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallbackMessageParser {

    private final ApplicationConfig config;

    public OrderCallbackMessage parse(String token) {
        //1、从map中取出加密过的message，使用urlDecode转码,
        try {
            String message = URLDecoder.decode(token, "GBK");

            //2、解密消息内容,密钥为client_secret注意修改
            byte[] bytes = new BASE64Decoder().decodeBuffer(message);

            //3、解密后的数据
            String decryResult = AESUtils.AESDecrypt(bytes, config.getClientSecret());

            return JSON.parseObject(decryResult, OrderCallbackMessage.class);
        } catch (Exception e) {
            log.error("failed to parse. token={}, ex={}", token, e);
        }
        return null;
    }

}
