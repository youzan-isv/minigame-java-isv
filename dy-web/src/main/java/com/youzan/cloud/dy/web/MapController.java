package com.youzan.cloud.dy.web;

import com.youzan.cloud.dy.api.model.ResultDTO;
import com.youzan.cloud.dy.biz.component.AMapClient;
import com.youzan.cloud.dy.biz.component.model.amap.AMapDistrictInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlinghong
 * @date 2021-04-26 17:00
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {

    private final AMapClient client;

    //统一接出
    //获取区域规划信息
    @GetMapping("/info")
    public ResultDTO<AMapDistrictInfo> getDistrictInfo(String cityName) {
        return ResultDTO.success(client.districtInfo(cityName));
    }

}
