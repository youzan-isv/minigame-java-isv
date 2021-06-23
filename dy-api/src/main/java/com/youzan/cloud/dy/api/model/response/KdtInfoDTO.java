package com.youzan.cloud.dy.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-26 10:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class KdtInfoDTO implements Serializable {

    private static final long serialVersionUID = 8551162018585912926L;

    private Long kdtId;

    /**
     * C 端跳转到应用的 URL
     */
    private JumpUrlDTO jumpUrl;

    /**
     * 订单信息
     */
    private OrderInfoDTO orderInfo;

    /**
     * 游戏信息
     */
    private GameInfoDTO gameInfo;
}
