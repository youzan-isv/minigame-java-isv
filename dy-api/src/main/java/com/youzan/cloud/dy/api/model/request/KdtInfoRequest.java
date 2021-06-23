package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-26 13:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KdtInfoRequest implements Serializable {

    private static final long serialVersionUID = -3953542199308265626L;

    private String newUserToken;
    private Long kdtId;
}
