package com.youzan.cloud.dy.biz.service;

import com.youzan.cloud.dy.api.model.request.KdtInfoRequest;
import com.youzan.cloud.dy.api.model.response.GameInfoDTO;
import com.youzan.cloud.dy.api.model.response.KdtInfoDTO;
import com.youzan.cloud.dy.api.model.response.OrderInfoDTO;
import com.youzan.cloud.dy.api.service.GameInfoService;
import com.youzan.cloud.dy.api.service.KdtInfoService;
import com.youzan.cloud.dy.api.service.OrderInfoService;
import com.youzan.cloud.dy.biz.api.YouzanAppstoreOpenUserGetClient;
import com.youzan.cloud.dy.biz.component.AppJumpUrlGenerator;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanAppstoreOpenUserGetResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chenlinghong
 * @date 2021-04-26 14:04
 */
@Service
@RequiredArgsConstructor
class KdtInfoServiceImpl implements KdtInfoService {

    private final OrderInfoService orderService;
    private final GameInfoService gameService;
    private final YouzanAppstoreOpenUserGetClient userClient;
    private final AppJumpUrlGenerator jumpUrlGenerator;

    @Override
    public KdtInfoDTO findKdtInfo(KdtInfoRequest request) {
        Long kdtId;
        if(request.getKdtId() != null && !request.getKdtId().equals("")){
            kdtId = request.getKdtId();
        }
        else {
            YouzanAppstoreOpenUserGetResult.YouzanAppstoreOpenUserGetResultData userData = userClient.appstoreOpenUser(request.getNewUserToken());
            if (null == userData) {
                return null;
            }
            kdtId = userData.getKdtId();
        }
        return KdtInfoDTO.builder()
                .kdtId(kdtId)
                .jumpUrl(jumpUrlGenerator.generate(kdtId))
                .gameInfo(GameInfoDTO.of(gameService.getByKdt(kdtId)))
                .orderInfo(OrderInfoDTO.of(orderService.getByKdt(kdtId)))
                .build();
    }
}
