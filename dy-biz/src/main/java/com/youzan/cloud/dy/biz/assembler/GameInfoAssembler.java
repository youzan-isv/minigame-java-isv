package com.youzan.cloud.dy.biz.assembler;

import com.youzan.cloud.dy.api.service.bo.GameInfoBO;
import com.youzan.cloud.dy.dal.po.GameInfoPO;
import lombok.NonNull;

/**
 * @author chenlinghong
 * @date 2021-04-22 20:52
 */
public abstract class GameInfoAssembler {

    public static GameInfoPO assemble(GameInfoBO bo) {
        if (null == bo) {
            return null;
        }
        return GameInfoPO.builder()
                .id(bo.getId())
                .kdtId(bo.getKdtId())
                .createdAt(bo.getCreatedAt())
                .updatedAt(bo.getUpdatedAt())
                .name(bo.getName())
                .build();
    }

    public static GameInfoBO assemble(GameInfoPO po) {
        if (null == po) {
            return null;
        }
        return GameInfoBO.builder()
                .id(po.getId())
                .kdtId(po.getKdtId())
                .name(po.getName())
                .createdAt(po.getCreatedAt())
                .updatedAt(po.getUpdatedAt())
                .build();
    }
}
