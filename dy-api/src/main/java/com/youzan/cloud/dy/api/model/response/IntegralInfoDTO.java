package com.youzan.cloud.dy.api.model.response;

import com.youzan.cloud.dy.api.service.bo.IntegralInfoBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class IntegralInfoDTO implements Serializable {

    private static final long serialVersionUID = 1941776417651782105L;

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
     * 电话号码
     */
    private String telephone;

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

    public static IntegralInfoDTO of(IntegralInfoBO data) {
        if(data == null){
            return  null;
        }
        IntegralInfoDTO res = new IntegralInfoDTO();

        res.setId(data.getId());
        res.setIntegralNum(data.getIntegralNum());
        res.setUpdatedAt(data.getUpdatedAt());
        res.setCreatedAt(data.getCreatedAt());
        res.setYzOpenId(data.getYzOpenId());
        res.setKdtId(data.getKdtId());

        return res;
    }
}
