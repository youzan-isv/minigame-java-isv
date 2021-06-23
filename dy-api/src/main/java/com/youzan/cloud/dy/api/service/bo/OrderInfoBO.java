package com.youzan.cloud.dy.api.service.bo;

import com.youzan.cloud.dy.api.model.callback.OrderCallbackMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:20
 *
 * order info business object
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderInfoBO implements Serializable {

    private static final long serialVersionUID = -8964268581097648079L;
    /**
     * 信息ID，主键
     */
    private Long id;

    /**
     * 店铺ID
     */
    private Long kdtId;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 生效时间
     */
    private Date effectTime;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    public static OrderInfoBO of(@NonNull OrderCallbackMessage message) {
        return OrderInfoBO.builder()
                .kdtId(message.getKdtId())
                .effectTime(new Date(message.getEffectTime()))
                .expireTime(new Date(message.getExpireTime()))
                .build();
    }
}
