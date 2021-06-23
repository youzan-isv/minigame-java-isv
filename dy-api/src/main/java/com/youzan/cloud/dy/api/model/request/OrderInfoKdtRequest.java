package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoKdtRequest implements Serializable {

    private static final long serialVersionUID = -7399973490185227806L;

    private Long kdtId;
}
