package com.youzan.cloud.dy.biz.component.model.amap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenlinghong
 * @date 2021-04-26 16:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AMapHttpResponse implements Serializable {

    private static final long serialVersionUID = -563125903538096529L;

    private Integer status;
    private String info;
    private String infocode;

    private List<AMapDistrictInfo> districts;
}
