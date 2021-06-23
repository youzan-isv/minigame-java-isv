package com.youzan.cloud.dy.api.service.bo;

import com.youzan.cloud.dy.api.model.request.IntegralInfoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:10 上午
 * <p>
 * integral history business object
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class IntegralInfoBO implements Serializable {

    private static final long serialVersionUID = -2253013661793378876L;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    /**
     * 更新时间
     */

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;

    public static IntegralInfoBO of(@NonNull IntegralInfoRequest request ) {
        return IntegralInfoBO.builder()
                .kdtId(request.getKdtId())
                .integralNum(request.getIntegralNum())
                .yzOpenId(request.getYzOpenId())
                .build();
    }
}
