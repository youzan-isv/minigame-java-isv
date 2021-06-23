package com.youzan.cloud.dy.dal.mapper;

import com.youzan.cloud.dy.dal.po.OrderInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenlinghong
 * @date 2021-04-21 11:10 下午
 */
public interface OrderInfoMapper {

    int insert(OrderInfoPO data);

    OrderInfoPO getByKdt(@Param("kdtId") Long kdtId);

    List<OrderInfoPO> listAll();
}
