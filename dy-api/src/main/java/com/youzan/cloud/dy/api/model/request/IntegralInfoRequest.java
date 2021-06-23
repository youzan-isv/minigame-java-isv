package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class IntegralInfoRequest implements Serializable {

    private static final long serialVersionUID = -3879804324246055811L;

    /**
     * 店铺ID
     */
    private Long kdtId;

    /**
     * 有赞ID
     */
    private String yzOpenId;

    /**
     * 积分发放数量
     */
    private Integer integralNum;

}
