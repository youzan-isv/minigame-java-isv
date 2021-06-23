package com.youzan.cloud.dy.api.model.response;

import com.youzan.cloud.dy.api.service.bo.GameInfoBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenlinghong
 * @date 2021-04-22 11:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GameInfoDTO implements Serializable {

    private static final long serialVersionUID = 5595002992707599547L;

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

    public static GameInfoDTO of(GameInfoBO bo) {
        if(bo == null){
            return  null;
        }
        GameInfoDTO res = new GameInfoDTO();
        res.setId(bo.getId());
        res.setKdtId(bo.getKdtId());
        res.setName(bo.getName());
        res.setUpdatedAt(bo.getUpdatedAt());
        res.setCreatedAt(bo.getCreatedAt());
        return res;
    }
}
