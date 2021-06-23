package com.youzan.cloud.dy.web;

import com.youzan.cloud.dy.api.enums.ErrorCodeEnum;
import com.youzan.cloud.dy.api.model.ResultDTO;
import com.youzan.cloud.dy.api.model.request.IntegralInfoKdtRequest;
import com.youzan.cloud.dy.api.model.request.IntegralInfoRequest;
import com.youzan.cloud.dy.api.model.response.IntegralInfoDTO;
import com.youzan.cloud.dy.api.service.IntegralService;
import com.youzan.cloud.dy.api.service.bo.IntegralInfoBO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenlinghong
 * @date 2021-04-21 11:04 下午
 * 发放积分controller
 */
@CrossOrigin
@RestController
@RequestMapping("/integral")
@RequiredArgsConstructor
public class IntegralController {

    //积分服务
    private final IntegralService service;

    //发放积分
    @PostMapping("/info")
    public ResultDTO<Void> add(@RequestBody IntegralInfoRequest request) {
        if (null == request) {
            return ResultDTO.fail(ErrorCodeEnum.PARAM_ILLEGAL);
        }

        service.insert(IntegralInfoBO.of(request));
        return ResultDTO.success();
    }

    /**
     * 获取积分发放记录
     * @param request
     * @return
     */
    @GetMapping("/info/kdt")
    public ResultDTO<List<IntegralInfoDTO>> listByKdt(IntegralInfoKdtRequest request) {
        return ResultDTO.success(
                service.listByKdt(request).stream().map(IntegralInfoDTO::of).collect(Collectors.toList())
        );
    }
}
