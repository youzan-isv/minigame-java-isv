package com.youzan.cloud.dy.api.service;

import com.youzan.cloud.dy.api.service.bo.OrderInfoBO;

import java.util.List;

/**
 * @author chenlinghong
 * @date 2021-04-21 11:10 下午
 */
public interface OrderInfoService {

    boolean add(OrderInfoBO data);

    /**
     * 根据店铺 ID 获取
     *
     * @param kdtId
     * @return
     */
    OrderInfoBO getByKdt(Long kdtId);

    /**
     * 获取所有订购信息，
     * <p>
     * TODO 此处仅用于示例，实际情况需要分页
     *
     * @return
     */
    List<OrderInfoBO> listAll();
}
