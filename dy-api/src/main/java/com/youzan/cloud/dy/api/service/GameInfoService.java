package com.youzan.cloud.dy.api.service;

import com.youzan.cloud.dy.api.service.bo.GameInfoBO;

/**
 * @author chenlinghong
 * @date 2021-04-22 9:51
 * <p>
 * game info service
 */
public interface GameInfoService {

    boolean add(GameInfoBO gameInfo);

    boolean delete(Long id);

    /**
     * 根据店铺ID获取
     *
     * @param kdtId 店铺ID
     * @return
     */
    GameInfoBO getByKdt(Long kdtId);

    boolean update(GameInfoBO gameInfo);

}
