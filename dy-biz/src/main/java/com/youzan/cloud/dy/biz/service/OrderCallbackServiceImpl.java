package com.youzan.cloud.dy.biz.service;

import com.youzan.cloud.component.token.EscrowTokenManager;
import com.youzan.cloud.dy.api.model.callback.OrderCallbackMessage;
import com.youzan.cloud.dy.api.service.OrderCallbackService;
import com.youzan.cloud.dy.api.service.OrderInfoService;
import com.youzan.cloud.dy.api.service.bo.OrderInfoBO;
import com.youzan.cloud.dy.biz.component.CallbackMessageParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chenlinghong
 * @date 2021-04-23 20:25
 */
@Service
@RequiredArgsConstructor
class OrderCallbackServiceImpl implements OrderCallbackService {

    //解密工具类
    private final CallbackMessageParser parser;
    //订单相关处理服务
    private final OrderInfoService orderService;
    //Token托管组件
    private final EscrowTokenManager escrowTokenManager;

    @Override
    public void message(String meg) {
        OrderCallbackMessage message = parser.parse(meg);

        // 此处仅处理 应用授权信息 为示例
        if (message.getExpireTime() != null) {
            orderService.add(OrderInfoBO.of(message));
        }
    }

    @Override
    public void code(String code) {
        // 注册code来进行Token托管，本处使用的redis来做托管，需要在DIY控制台中开启redis组件
        // 可以参考文档
        //https://doc.youzanyun.com/resource/develop-guide/41356/41743
        escrowTokenManager.registerCode(code);
    }
}
