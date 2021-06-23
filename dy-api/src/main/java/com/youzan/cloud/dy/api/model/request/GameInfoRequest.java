package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GameInfoRequest implements Serializable {

    private static final long serialVersionUID = -5754206611012769967L;

    private Long id;

    /**
     * 游戏名称
     */
    private String name;

    /**
     * 店铺ID
     */
    private Long kdtId;
}
