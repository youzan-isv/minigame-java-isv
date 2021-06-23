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
 * @date 2021-04-21 10:24 下午
 *
 * 积分发放记录
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class IntegralInfoPO implements Serializable {

    private static final long serialVersionUID = 5962337813267360190L;

    /**
     * 主键
     */
    private Long id;

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

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}
