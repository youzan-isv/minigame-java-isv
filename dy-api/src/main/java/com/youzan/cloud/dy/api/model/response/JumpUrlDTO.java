package com.youzan.cloud.dy.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-26 14:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JumpUrlDTO implements Serializable {

    private static final long serialVersionUID = 5398334071902742965L;

    private Long kdtId;

    /**
     * 小程序跳转 URL
     */
    private String mpUrl;

    /**
     * H5 跳转 URL
     */
    private String h5Url;
}
