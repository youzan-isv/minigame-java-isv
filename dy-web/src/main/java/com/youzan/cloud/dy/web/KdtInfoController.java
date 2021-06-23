package com.youzan.cloud.dy.web;

import com.youzan.cloud.dy.api.enums.ErrorCodeEnum;
import com.youzan.cloud.dy.api.model.ResultDTO;
import com.youzan.cloud.dy.api.model.request.KdtInfoRequest;
import com.youzan.cloud.dy.api.model.response.KdtInfoDTO;
import com.youzan.cloud.dy.api.service.KdtInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlinghong
 * @date 2021-04-26 10:18
 */
@CrossOrigin
@RestController
@RequestMapping("/kdt")
@RequiredArgsConstructor
public class KdtInfoController {

    //店铺信息服务
    private final KdtInfoService kdtService;

    //根据 newUserToken 或 kdtId 获取店铺信息
    @GetMapping("/info")
    public ResultDTO<KdtInfoDTO> getKdtInfo(KdtInfoRequest request) {
        if (null == request || (StringUtils.isEmpty(request.getNewUserToken()) && StringUtils.isEmpty(request.getKdtId()))) {
            return ResultDTO.fail(ErrorCodeEnum.PARAM_ILLEGAL);
        }
        return ResultDTO.success(kdtService.findKdtInfo(request));
    }

}
