package com.youzan.cloud.dy.biz.api;

import com.youzan.cloud.base.api.BifrostService;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.gen.v4_0_0.api.YouzanCrmCustomerPointsIncrease;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanCrmCustomerPointsIncreaseParams;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanCrmCustomerPointsIncreaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author chenlinghong
 * @date 2021-05-18 11:59
 * <p>
 * 给用户加积分：https://doc.youzanyun.com/detail/API/0/872
 */
@Slf4j
@Component
public class YouzanCrmCustomerPointsIncreaseClient {

    @Resource
    private BifrostService CLIENT;

    public boolean increase(String token, String yzOpenId,Integer point) {
        Token tokenBean = new Token(token);

        YouzanCrmCustomerPointsIncrease youzanCrmCustomerPointsIncrease = new YouzanCrmCustomerPointsIncrease();
        // 创建参数对象,并设置参数
        YouzanCrmCustomerPointsIncreaseParams youzanCrmCustomerPointsIncreaseParams = new YouzanCrmCustomerPointsIncreaseParams();
        YouzanCrmCustomerPointsIncreaseParams.YouzanCrmCustomerPointsIncreaseParamsParams youzanCrmCustomerPointsIncreaseParamsParams = new YouzanCrmCustomerPointsIncreaseParams.YouzanCrmCustomerPointsIncreaseParamsParams();
        youzanCrmCustomerPointsIncreaseParamsParams.setReason("玩游戏奖励积分");
        //youzanCrmCustomerPointsIncreaseParamsParams.setBizValue("IN20190820002");
        youzanCrmCustomerPointsIncreaseParamsParams.setPoints(point);
        YouzanCrmCustomerPointsIncreaseParams.YouzanCrmCustomerPointsIncreaseParamsUser youzanCrmCustomerPointsIncreaseParamsUser = new YouzanCrmCustomerPointsIncreaseParams.YouzanCrmCustomerPointsIncreaseParamsUser();
        youzanCrmCustomerPointsIncreaseParamsUser.setAccountType(5);
        youzanCrmCustomerPointsIncreaseParamsUser.setAccountId(yzOpenId);
        youzanCrmCustomerPointsIncreaseParamsParams.setUser(youzanCrmCustomerPointsIncreaseParamsUser);
        youzanCrmCustomerPointsIncreaseParams.setParams(youzanCrmCustomerPointsIncreaseParamsParams);
        youzanCrmCustomerPointsIncrease.setAPIParams(youzanCrmCustomerPointsIncreaseParams);

        YouzanCrmCustomerPointsIncreaseResult result = null;
        try {
            result = CLIENT.invoke(youzanCrmCustomerPointsIncrease, tokenBean, YouzanCrmCustomerPointsIncreaseResult.class);
        } catch (SDKException e) {
            log.warn("failed to increase. token={}, yzOpenId={}", token, yzOpenId);
        }

        return Optional.ofNullable(result)
                .filter(YouzanCrmCustomerPointsIncreaseResult::getSuccess)
                .map(YouzanCrmCustomerPointsIncreaseResult::getData)
                .map(YouzanCrmCustomerPointsIncreaseResult.YouzanCrmCustomerPointsIncreaseResultData::getIsSuccess)
                .filter("true"::equalsIgnoreCase)
                .isPresent();
    }

}
