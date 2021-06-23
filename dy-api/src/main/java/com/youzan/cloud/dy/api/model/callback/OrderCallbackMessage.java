package com.youzan.cloud.dy.api.model.callback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 22:44
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCallbackMessage implements Serializable {

    private static final long serialVersionUID = -7871056859491914510L;

    /**
     * 消息类型
     */
    private MessageType type;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 套餐名称
     */
    private String skuVersionText;

    /**
     * 套餐有效期，单位：天
     */
    private Integer skuIntervalText;

    /**
     * 订购人手机号
     */
    private String buyerPhone;

    /**
     * 支付时间，时间戳，单位：ms
     */
    private Long payTime;

    /**
     * 失效时间，时间戳，单位：ms
     */
    private Long expireTime;

    /**
     * 生效时间
     */
    private Long effectTime;

    /**
     * 店铺ID
     */
    private Long kdtId;

    /**
     * 店铺编号
     */
    private Long shopDisPlayNo;

    /**
     * 订单价格，单位：分
     */
    private Long price;

    /**
     * 应用ID
     */
    private Long appId;

    /**
     * 购买者身份标识
     */
    private Long buyerId;

    /**
     * 购买者的 yzOpenId
     */
    private String openId;

    /**
     * 支付状态，20：支付成功
     */
    private String status;

    /**
     * 环境参数
     */
    private Environment env;
}
