package com.youzan.cloud.dy.api.service;

import com.youzan.cloud.dy.api.model.request.IntegralInfoKdtRequest;
import com.youzan.cloud.dy.api.service.bo.IntegralInfoBO;

import java.util.List;

/**
 * @author chenlinghong
 * @date 2021-04-21 11:04 下午
 */
public interface IntegralService {

    boolean insert(IntegralInfoBO data);

    /**
     * 根据店铺 ID 获取
     *
     * @return
     */
    List<IntegralInfoBO> listByKdt(IntegralInfoKdtRequest request);
}
