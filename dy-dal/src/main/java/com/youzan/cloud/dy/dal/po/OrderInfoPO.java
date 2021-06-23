package com.youzan.cloud.dy.dal.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-21 10:26 下午
 *
 * 订购信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderInfoPO implements Serializable {

    private static final long serialVersionUID = 1963135692709212374L;

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
}
