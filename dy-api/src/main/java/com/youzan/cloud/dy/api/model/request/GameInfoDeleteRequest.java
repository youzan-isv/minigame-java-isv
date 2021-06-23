package com.youzan.cloud.dy.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenlinghong
 * @date 2021-04-22 11:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoDeleteRequest implements Serializable {

    private static final long serialVersionUID = 5586079954106987659L;

    private Long kdtId;
}
