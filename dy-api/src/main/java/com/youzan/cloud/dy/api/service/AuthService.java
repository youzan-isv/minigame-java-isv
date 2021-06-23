package com.youzan.cloud.dy.api.service;

/**
 * @author chenlinghong
 * @date 2021-04-25 20:47
 */
public interface AuthService {

    /**
     * 校验权限
     *
     * @param kdtId
     * @return
     */
    boolean checkAuth(Long kdtId);

}
