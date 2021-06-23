package com.youzan.cloud.dy.biz.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chenlinghong
 * @date 2021-04-23 20:15
 * 应用变量使用文档 https://doc.youzanyun.com/resource/develop-guide/41356/41619
 */
@Component
@Getter
public class ApplicationConfig {

    @Value("${opensdk.clientId}")
    private String clientId;

    @Value("${opensdk.clientSecret}")
    private String clientSecret;

    /**
     * 高德地图 key
     */
    @Value("${amap.api.key}")
    private String amapKey;

    /**
     * 应用入口 URL
     */
    @Value("${mp.url}")
    private String mpUrl;
    @Value("${html.url}")
    private String h5Url;
}
