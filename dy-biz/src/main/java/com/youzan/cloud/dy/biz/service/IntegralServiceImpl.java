package com.youzan.cloud.dy.biz.service;

import com.youzan.cloud.dy.api.exception.BizException;
import com.youzan.cloud.dy.api.model.request.IntegralInfoKdtRequest;
import com.youzan.cloud.dy.api.service.AuthService;
import com.youzan.cloud.dy.api.service.IntegralService;
import com.youzan.cloud.dy.api.service.bo.IntegralInfoBO;
import com.youzan.cloud.dy.biz.api.YouzanCrmCustomerPointsIncreaseClient;
import com.youzan.cloud.dy.biz.assembler.IntegralHistoryAssembler;
import com.youzan.cloud.dy.biz.component.EscrowTokenManagerProxy;
import com.youzan.cloud.dy.dal.mapper.IntegralInfoMapper;
import com.youzan.cloud.dy.dal.po.IntegralInfoPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:08
 */
@Service
@RequiredArgsConstructor
class IntegralServiceImpl implements IntegralService {

    private final IntegralInfoMapper mapper;
    private final AuthService authService;
    private final YouzanCrmCustomerPointsIncreaseClient client;
    private final EscrowTokenManagerProxy proxy;

    @Override
    public boolean insert(IntegralInfoBO data) {
        if (!authService.checkAuth(data.getKdtId())) {
            throw new BizException("未授权");
        }

        // 给用户加积分
        if (!client.increase(proxy.getAccessToken(data.getKdtId()), data.getYzOpenId(),data.getIntegralNum())) {
            throw new BizException("发放积分失败");
        }

        return 1 == mapper.insert(IntegralHistoryAssembler.assemble(data));
    }

    @Override
    public List<IntegralInfoBO> listByKdt(IntegralInfoKdtRequest request) {
        if (!authService.checkAuth(request.getKdtId())) {
            throw new BizException("未授权");
        }

        List<IntegralInfoBO> resultList = new ArrayList<>();

        List<IntegralInfoPO> pos = mapper.listByKdt(request.getKdtId(), request.getStartTime(), request.getEndTime());
        if (null != pos && pos.size() > 0) {
            resultList = pos.stream().map(IntegralHistoryAssembler::assemble).collect(Collectors.toList());
        }

        return resultList;
    }

}
