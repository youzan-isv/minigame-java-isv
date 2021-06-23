package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderInfoRequest implements Serializable {

    private static final long serialVersionUID = -2690006300550374195L;

    /**
     * 店铺ID
     */
    private Long kdtId;

    /**
     * 订购时间
     */
    private Date orderTime;

    /**
     * 过期时间
     */
    private Date expirationTime;

}
