package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntegralInfoTokenRequest implements Serializable {

    private static final long serialVersionUID = 5569544334176634739L;

    private String newUserToken;

    /**
     * 查询时间段
     */
    private Date startTime;
    private Date endTime;
}
