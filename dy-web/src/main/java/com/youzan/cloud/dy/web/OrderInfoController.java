package com.youzan.cloud.dy.web;

import com.youzan.cloud.dy.api.model.ResultDTO;
import com.youzan.cloud.dy.api.service.OrderInfoService;
import com.youzan.cloud.dy.api.model.request.OrderInfoKdtRequest;
import com.youzan.cloud.dy.api.model.response.OrderInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:18
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderInfoController {

    private final OrderInfoService service;

    /**
     * 根据店铺 ID 获取
     *
     * @return
     */
    @GetMapping("/info")
    public ResultDTO<OrderInfoDTO> getByKdt(OrderInfoKdtRequest request) {
        return ResultDTO.success(OrderInfoDTO.of(service.getByKdt(request.getKdtId())));
    }

    /**
     * 获取所有订购信息，
     * <p>
     * TODO 此处仅用于示例，实际情况需要分页
     *
     * @return
     */
    @GetMapping("/all")
    public ResultDTO<List<OrderInfoDTO>> listAll() {
        return ResultDTO.success(service.listAll().stream().map(OrderInfoDTO::of).collect(Collectors.toList()));
    }
}
