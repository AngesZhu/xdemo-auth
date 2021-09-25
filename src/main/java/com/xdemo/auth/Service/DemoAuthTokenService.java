package com.xdemo.auth.Service;

import com.xdemo.auth.Entity.DemoAuthTokenDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
public interface DemoAuthTokenService extends IService<DemoAuthTokenDO> {
    List<DemoAuthTokenDO> getToken();

    DemoAuthTokenDO getTokenByUserId(int id);

    DemoAuthTokenDO checkUserByToken(String token);

    boolean deleteToken(int id);

    Integer updateToken(DemoAuthTokenDO userObject);

    void deleteTokenByToken(String token, Date updated_at);

    void deleteTokenByUserId(Integer userId, Date updated_at);

    void createToken(DemoAuthTokenDO demoAuthTokenDO);
}
