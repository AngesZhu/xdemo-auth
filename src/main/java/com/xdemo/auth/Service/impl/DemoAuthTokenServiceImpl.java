package com.xdemo.auth.Service.impl;

import com.xdemo.auth.Entity.DemoAuthTokenDO;
import com.xdemo.auth.Repository.DemoAuthTokenMapper;
import com.xdemo.auth.Service.DemoAuthTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
@Service("DemoAuthTokenServiceBase")
@Primary
public class DemoAuthTokenServiceImpl extends ServiceImpl<DemoAuthTokenMapper, DemoAuthTokenDO> implements DemoAuthTokenService {

    @Autowired
    DemoAuthTokenMapper demoAuthTokenMapper;

    @Override
    public List<DemoAuthTokenDO> getToken() {
        return demoAuthTokenMapper.selectList(null);
    }

    @Override
    public DemoAuthTokenDO getTokenByUserId(int id){
        return demoAuthTokenMapper.selectById(id);
    }

    @Override
    public DemoAuthTokenDO checkUserByToken(String token) {
        return demoAuthTokenMapper.checkUserByToken(token);
    }

    @Override
    public boolean deleteToken(int id){
        demoAuthTokenMapper.deleteById(id);
        return true;
    }

    @Override
    public Integer updateToken(DemoAuthTokenDO demoAuthTokenDO){

        return demoAuthTokenMapper.updateById(demoAuthTokenDO);
    }

    @Override
    public void deleteTokenByToken(String token, Date updated_at) {
        demoAuthTokenMapper.deleteTokenByToken(token, updated_at);
    }

    @Override
    public void deleteTokenByUserId(Integer userId, Date updated_at) {
        demoAuthTokenMapper.deleteTokenByUserId(userId, updated_at);
    }

    @Override
    public void createToken(DemoAuthTokenDO demoAuthTokenDO){
        demoAuthTokenMapper.insert(demoAuthTokenDO);
    }
}
