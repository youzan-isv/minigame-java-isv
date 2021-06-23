package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
public class IntegralInfoKdtRequest implements Serializable {

    private static final long serialVersionUID = 5569544334176634739L;

    private Long kdtId;

    /**
     * 查询时间段
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
