package com.youzan.cloud.dy.api.service;

import com.youzan.cloud.dy.api.model.request.KdtInfoRequest;
import com.youzan.cloud.dy.api.model.response.KdtInfoDTO;

/**
 * @author chenlinghong
 * @date 2021-04-26 14:02
 */
public interface KdtInfoService {

    KdtInfoDTO findKdtInfo(KdtInfoRequest request);
}
