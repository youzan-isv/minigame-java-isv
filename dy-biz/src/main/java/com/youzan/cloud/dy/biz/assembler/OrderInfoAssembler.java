package com.youzan.cloud.dy.biz.assembler;

import com.youzan.cloud.dy.api.service.bo.OrderInfoBO;
import com.youzan.cloud.dy.dal.po.OrderInfoPO;
import lombok.NonNull;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:14
 */
public abstract class OrderInfoAssembler {

    public static OrderInfoBO assemble(OrderInfoPO data) {
        if (null == data) {
            return null;
        }

        return OrderInfoBO.builder()
                .id(data.getId())
                .createdAt(data.getCreatedAt())
                .effectTime(data.getEffectTime())
                .kdtId(data.getKdtId())
                .updatedAt(data.getUpdatedAt())
                .expireTime(data.getExpireTime())
                .build();
    }

    public static OrderInfoPO assemble( OrderInfoBO data) {
        if (null == data) {
            return null;
        }
        return OrderInfoPO.builder()
                .id(data.getId())
                .createdAt(data.getCreatedAt())
                .effectTime(data.getEffectTime())
                .kdtId(data.getKdtId())
                .updatedAt(data.getUpdatedAt())
                .expireTime(data.getExpireTime())
                .build();
    }

}
