package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 11:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoFindRequest implements Serializable {

    private static final long serialVersionUID = 294829748047589812L;

    private Long kdtId;
}
