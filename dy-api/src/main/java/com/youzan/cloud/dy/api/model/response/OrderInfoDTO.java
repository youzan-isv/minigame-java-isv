package com.youzan.cloud.dy.api.model.response;

import com.youzan.cloud.dy.api.service.bo.OrderInfoBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderInfoDTO implements Serializable {

    private static final long serialVersionUID = 6705398890869565504L;

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

    public static OrderInfoDTO of(OrderInfoBO bo) {
        if(bo == null){
            return  null;
        }
        OrderInfoDTO res = new OrderInfoDTO();

        res.setId(bo.getId());
        res.setExpireTime(bo.getExpireTime());
        res.setCreatedAt(bo.getCreatedAt());
        res.setKdtId(bo.getKdtId());
        res.setEffectTime(bo.getEffectTime());
        res.setUpdatedAt(bo.getUpdatedAt());

        return res;
    }
}
