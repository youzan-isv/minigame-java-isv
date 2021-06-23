package com.youzan.cloud.dy.web;

import com.youzan.cloud.dy.api.enums.ErrorCodeEnum;
import com.youzan.cloud.dy.api.model.ResultDTO;
import com.youzan.cloud.dy.api.service.GameInfoService;
import com.youzan.cloud.dy.api.service.bo.GameInfoBO;
import com.youzan.cloud.dy.api.model.request.GameInfoDeleteRequest;
import com.youzan.cloud.dy.api.model.request.GameInfoFindRequest;
import com.youzan.cloud.dy.api.model.request.GameInfoRequest;
import com.youzan.cloud.dy.api.model.response.GameInfoDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:28
 * <p>
 * game info http controller
 */
@CrossOrigin
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameInfoController {

    private final GameInfoService service;

    /**
     * 新增游戏信息
     *
     * @param request
     * @return
     */
    @PostMapping("/info")
    public ResultDTO<Void> add(@RequestBody GameInfoRequest request) {
        if (null == request) {
            return ResultDTO.fail(ErrorCodeEnum.PARAM_ILLEGAL);
        }

        service.add(convert(request));
        return ResultDTO.success();
    }

    /**
     * 删除游戏信息
     * @param request
     * @return
     */
    @GetMapping("/infoDelete")
    public ResultDTO<Void> infoDelete(GameInfoDeleteRequest request) {
        service.delete(request.getKdtId());
        return ResultDTO.success();
    }

    /**
     * 根据店铺ID获取游戏信息
     *
     * @return
     */
    @GetMapping("/info")
    public ResultDTO<GameInfoDTO> getByKdt(GameInfoFindRequest request) {
        return ResultDTO.success(GameInfoDTO.of(service.getByKdt(request.getKdtId())));
    }

/*    @PutMapping("/info")
    public ResultDTO<Void> update(GameInfoRequest request) {
        service.update(convert(request));
        return ResultDTO.success();
    }*/

    /**
     * 工具转换类
     * @param request
     * @return
     */
    private static GameInfoBO convert(@NonNull GameInfoRequest request) {
        return GameInfoBO.builder()
                .id(request.getId())
                .kdtId(request.getKdtId())
                .name(request.getName())
                .build();
    }

}
