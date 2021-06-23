package com.youzan.cloud.dy.biz.component.model.amap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenlinghong
 * @date 2021-04-26 16:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AMapDistrictInfo implements Serializable {

    private static final long serialVersionUID = -7248644103170956977L;

    private String citycode;
    private String adcode;
    private String name;
    private String center;
    private String level;

    private List<AMapDistrictInfo> districts;
}
