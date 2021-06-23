package com.youzan.cloud.dy.biz.service;

import com.youzan.cloud.dy.api.service.OrderInfoService;
import com.youzan.cloud.dy.api.service.bo.OrderInfoBO;
import com.youzan.cloud.dy.biz.assembler.OrderInfoAssembler;
import com.youzan.cloud.dy.dal.mapper.OrderInfoMapper;
import com.youzan.cloud.dy.dal.po.OrderInfoPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenlinghong
 * @date 2021-04-22 21:13
 */
@Service
@RequiredArgsConstructor
class OrderInfoServiceImpl implements OrderInfoService {

    private final OrderInfoMapper mapper;

    @Override
    public boolean add(OrderInfoBO data) {
        return 1 == mapper.insert(OrderInfoAssembler.assemble(data));
    }

    @Override
    public OrderInfoBO getByKdt(Long kdtId) {
        return OrderInfoAssembler.assemble(mapper.getByKdt(kdtId));
    }

    @Override
    public List<OrderInfoBO> listAll() {
        List<OrderInfoBO> resultList = new ArrayList<>();

        List<OrderInfoPO> pos = mapper.listAll();
        if (null != pos && pos.size() > 0) {
            resultList = pos.stream().map(OrderInfoAssembler::assemble).collect(Collectors.toList());
        }

        return resultList;
    }
}
