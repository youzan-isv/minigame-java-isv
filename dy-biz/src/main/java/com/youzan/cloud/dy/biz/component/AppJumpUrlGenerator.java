package com.youzan.cloud.dy.biz.component;

import com.youzan.cloud.dy.api.model.response.JumpUrlDTO;
import com.youzan.cloud.dy.biz.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author chenlinghong
 * @date 2021-04-26 14:15
 */
@Component
@RequiredArgsConstructor
public class AppJumpUrlGenerator {

    private final ApplicationConfig config;

    public JumpUrlDTO generate(Long kdtId) {
        return JumpUrlDTO.builder()
                .kdtId(kdtId)
                .h5Url(String.format(config.getH5Url(), kdtId))
                .mpUrl(config.getMpUrl())
                .build();
    }

}
