package com.youzan.cloud.dy.biz.component;

import com.youzan.cloud.dy.biz.component.model.amap.AMapDistrictInfo;
import com.youzan.cloud.dy.biz.component.model.amap.AMapHttpResponse;
import com.youzan.cloud.dy.biz.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenlinghong
 * @date 2021-04-26 16:42
 */
@Component
@RequiredArgsConstructor
public class AMapClient {

    //静态配置类
    private final ApplicationConfig config;
    //在框架中，对 resttemplate 做了 http proxy 封装，进行外部 url 请求需要使用 RestTemplate。
    private final RestTemplate restTemplate;

    /**
     * https://lbs.amap.com/api/webservice/guide/api/district
     */
    public AMapDistrictInfo districtInfo(String cityName) {
        String url = String.format(AMAP_URL_FORMAT, cityName, config.getAmapKey());
        AMapHttpResponse response = restTemplate.getForObject(url, AMapHttpResponse.class);

        return null != response && !CollectionUtils.isEmpty(response.getDistricts()) ? response.getDistricts().get(0) : null;
    }

    //模拟请求地图api返回地图信息
    private static final String AMAP_URL_FORMAT = "https://restapi.amap.com/v3/config/district?keywords=%s&subdistrict=2&key=%s";
}
