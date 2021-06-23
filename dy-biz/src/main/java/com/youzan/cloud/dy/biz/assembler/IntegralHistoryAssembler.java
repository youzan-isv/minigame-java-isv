package com.youzan.cloud.dy.biz.assembler;

import com.youzan.cloud.dy.api.service.bo.IntegralInfoBO;
import com.youzan.cloud.dy.dal.po.IntegralInfoPO;
import lombok.NonNull;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:08
 */
public abstract class IntegralHistoryAssembler {

    public static IntegralInfoBO assemble( IntegralInfoPO data) {
        if (null == data) {
            return null;
        }
        return IntegralInfoBO.builder()
                .id(data.getId())
                .integralNum(data.getIntegralNum())
                .kdtId(data.getKdtId())
                .yzOpenId(data.getYzOpenId())
                .updatedAt(data.getUpdatedAt())
                .createdAt(data.getCreatedAt())
                .build();
    }

    public static IntegralInfoPO assemble(IntegralInfoBO data) {
        if (null == data) {
            return null;
        }
        return IntegralInfoPO.builder()
                .id(data.getId())
                .integralNum(data.getIntegralNum())
                .kdtId(data.getKdtId())
                .yzOpenId(data.getYzOpenId())
                .updatedAt(data.getUpdatedAt())
                .createdAt(data.getCreatedAt())
                .build();
    }

}
