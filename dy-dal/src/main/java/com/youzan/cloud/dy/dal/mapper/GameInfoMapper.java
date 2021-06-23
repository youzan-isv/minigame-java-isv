package com.youzan.cloud.dy.dal.mapper;

import com.youzan.cloud.dy.dal.po.GameInfoPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenlinghong
 * @date 2021-04-21 10:34 下午
 */
public interface GameInfoMapper {

    int insert(GameInfoPO data);

    int deleteByKdtId(@Param("kdtId") Long kdtId);

    /**
     * 根据店铺ID获取
     *
     * @param kdtId 店铺ID
     * @return
     */
    GameInfoPO getByKdt(@Param("kdtId") Long kdtId);

    int update(GameInfoPO data);

}
