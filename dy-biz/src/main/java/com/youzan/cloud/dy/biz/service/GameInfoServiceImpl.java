package com.youzan.cloud.dy.biz.service;

import com.youzan.cloud.dy.api.exception.BizException;
import com.youzan.cloud.dy.api.service.AuthService;
import com.youzan.cloud.dy.api.service.GameInfoService;
import com.youzan.cloud.dy.api.service.bo.GameInfoBO;
import com.youzan.cloud.dy.biz.assembler.GameInfoAssembler;
import com.youzan.cloud.dy.dal.mapper.GameInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chenlinghong
 * @date 2021-04-22 10:27
 */
@Service
@RequiredArgsConstructor
class GameInfoServiceImpl implements GameInfoService {

    private final GameInfoMapper mapper;
    private final AuthService authService;

    @Override
    public boolean add(GameInfoBO gameInfo) {
        if (!authService.checkAuth(gameInfo.getKdtId())) {
            throw new BizException("未授权");
        }

        return 1 == mapper.insert(GameInfoAssembler.assemble(gameInfo));
    }

    @Override
    public boolean delete(Long kdtId) {
        if (!authService.checkAuth(kdtId)) {
            throw new BizException("未授权");
        }

        return 1 == mapper.deleteByKdtId(kdtId);
    }

    @Override
    public GameInfoBO getByKdt(Long kdtId) {
        return GameInfoAssembler.assemble(mapper.getByKdt(kdtId));
    }

    @Override
    public boolean update(GameInfoBO gameInfo) {
        if (!authService.checkAuth(gameInfo.getKdtId())) {
            throw new BizException("未授权");
        }

        return 1 == mapper.update(GameInfoAssembler.assemble(gameInfo));
    }
}
