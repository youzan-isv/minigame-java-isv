package com.youzan.cloud.dy.dal.mapper;

import com.youzan.cloud.dy.dal.po.IntegralInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author chenlinghong
 * @date 2021-04-21 11:04 下午
 */
public interface IntegralInfoMapper {

    int insert(IntegralInfoPO data);

    List<IntegralInfoPO> listByKdt(@Param("kdtId") Long kdtId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
