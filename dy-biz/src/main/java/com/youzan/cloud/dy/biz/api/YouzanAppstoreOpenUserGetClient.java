package com.youzan.cloud.dy.biz.api;

import com.youzan.cloud.base.api.BifrostService;
import com.youzan.cloud.component.token.EscrowTokenManager;
import com.youzan.cloud.component.token.OauthToken;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanAppstoreOpenUserGet;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanAppstoreOpenUserGetParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanAppstoreOpenUserGetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * @author chenlinghong
 * @date 2021-04-25 20:57
 * <p>
 * API描述：根据token查询用户使用信息
 * https://doc.youzanyun.com/detail/API/0/707
 */
@Slf4j
@Component
public class YouzanAppstoreOpenUserGetClient {

    @Resource
    private BifrostService CLIENT;

    @Resource
    private EscrowTokenManager escrowTokenManager;

    @Value("${cloud.auth.kdtid}")
    String kdtids;

    public YouzanAppstoreOpenUserGetResult.YouzanAppstoreOpenUserGetResultData appstoreOpenUser(String newUserToken) {

        String[] kdtidsList = kdtids.replace("\"","").replace("[","").replace("]","").split(",");
        //取任意有效授权的店铺ID，此处取的是最近授权的店铺
        String kdtID = kdtidsList[kdtidsList.length-1];
        if (kdtID.length() < 8) {
            throw new IllegalArgumentException("the oauth token of getting  not exists. ");
        }
        //获取Token
        OauthToken oauthToken = escrowTokenManager.getToken(kdtID);
        if (Objects.isNull(oauthToken)) {
            escrowTokenManager.registerAuthorityId(kdtID);
            throw new IllegalArgumentException("the oauth token of getting with using the kdtId[" + kdtID + "] not exists. ");
        }
        //创建 Auth 验证方式对象
        Token token = new Token(oauthToken.getAccessToken());
        YouzanAppstoreOpenUserGet youzanAppstoreOpenUserGet = new YouzanAppstoreOpenUserGet();
        //创建参数对象,并设置参数
        YouzanAppstoreOpenUserGetParams youzanAppstoreOpenUserGetParams = new YouzanAppstoreOpenUserGetParams();
        youzanAppstoreOpenUserGetParams.setUserToken(newUserToken);
        youzanAppstoreOpenUserGet.setAPIParams(youzanAppstoreOpenUserGetParams);
        YouzanAppstoreOpenUserGetResult result = null;
        try {
            result = CLIENT.invoke(youzanAppstoreOpenUserGet, token, YouzanAppstoreOpenUserGetResult.class);
        } catch (SDKException e) {
            log.warn("failed to get user info. newUserToken={}", newUserToken);
        }

        return Optional.ofNullable(result)
                .filter(YouzanAppstoreOpenUserGetResult::getSuccess)
                .map(YouzanAppstoreOpenUserGetResult::getData)
                .orElse(null);
    }

}
