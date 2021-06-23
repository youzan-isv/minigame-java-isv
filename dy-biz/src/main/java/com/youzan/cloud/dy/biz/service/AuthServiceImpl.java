package com.youzan.cloud.dy.biz.service;

import com.youzan.cloud.dy.api.service.AuthService;
import com.youzan.cloud.dy.api.service.OrderInfoService;
import com.youzan.cloud.dy.api.service.bo.OrderInfoBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-25 20:47
 */
@Service
@RequiredArgsConstructor
class AuthServiceImpl implements AuthService {

    private final OrderInfoService orderService;

    @Override
    public boolean checkAuth(Long kdtId) {
        OrderInfoBO orderInfo = orderService.getByKdt(kdtId);
        if (null == orderInfo || null == orderInfo.getEffectTime() || null == orderInfo.getExpireTime()) {
            return false;
        }

        Date now = new Date();
        return now.after(orderInfo.getEffectTime()) && now.before(orderInfo.getExpireTime());
    }
}
