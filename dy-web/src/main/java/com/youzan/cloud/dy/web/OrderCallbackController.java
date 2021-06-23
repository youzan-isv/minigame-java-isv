package com.youzan.cloud.dy.web;

import com.youzan.cloud.dy.api.service.OrderCallbackService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlinghong
 * @date 2021-04-22 22:42
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class OrderCallbackController {

    private final static Logger logger = LoggerFactory.getLogger(OrderCallbackController.class);
    private final OrderCallbackService service;

    /**
     * 订购回调
     * https://doc.youzanyun.com/resource/develop-guide/41356/41634
     * @param message
     * @param code
     */
    @GetMapping("/callback")
    public void callback(String message, String code) {
        if (StringUtils.isEmpty(message)) {
            logger.info("code: "+code);
            service.code(code);
        } else {
            logger.info("message: {}",message);
            service.message(message);
        }
    }

}
