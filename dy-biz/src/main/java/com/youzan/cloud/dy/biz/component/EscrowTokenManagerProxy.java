package com.youzan.cloud.dy.biz.component;

import com.youzan.cloud.component.token.EscrowTokenManager;
import com.youzan.cloud.component.token.OauthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author chenlinghong
 * @date 2021-05-18 14:07
 */
@Component
@RequiredArgsConstructor
public class EscrowTokenManagerProxy {

    private final EscrowTokenManager tokenManager;

    //根据店铺ID获取accesstoken
    public String getAccessToken(Long kdtId) {
        return Optional.ofNullable(tokenManager.getToken(String.valueOf(kdtId))).map(OauthToken::getAccessToken).orElse(null);
    }
}
