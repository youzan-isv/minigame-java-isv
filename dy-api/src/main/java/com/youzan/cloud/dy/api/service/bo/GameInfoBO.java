package com.youzan.cloud.dy.api.service.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 9:56
 * <p>
 * gram info business object
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GameInfoBO implements Serializable {

    private static final long serialVersionUID = 6105990036748108531L;

    /**
     * 信息ID，主键
     */
    private Long id;

    /**
     * 游戏名称
     */
    private String name;

    /**
     * 店铺ID
     */
    private Long kdtId;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}
