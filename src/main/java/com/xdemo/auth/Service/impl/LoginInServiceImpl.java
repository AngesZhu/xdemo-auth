package com.xdemo.auth.Service.impl;

import com.xdemo.auth.Definition.Pojo.UserLoginDTO;
import com.xdemo.auth.Definition.Pojo.UserLoginPO;
import com.xdemo.auth.Entity.DemoAuthTokenDO;
import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.xdemo.auth.Service.DemoAuthTokenService;
import com.xdemo.auth.Service.DemoAuthUserService;
import com.xdemo.auth.Service.LoginInService;
import com.xdemo.auth.Utils.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiMeng
 * @since 2021-04-29
 */
@SuppressWarnings("rawtypes")
@Service("LoginInServiceBase")
@Slf4j
public class LoginInServiceImpl implements LoginInService {

    @Autowired
    @Qualifier("DemoAuthUserServiceBase")
    DemoAuthUserService iDemoAuthUserService;

    @Autowired
    @Qualifier("DemoAuthTokenServiceBase")
    DemoAuthTokenService iDemoAuthTokenService;

    @Autowired
    RedisUtils redisUtils;

    @Override
    public ResponseData loginIn(UserLoginDTO userLoginDTO) {
        log.info("判断用户是否存在");
        UserLoginPO userLoginPO = new UserLoginPO();
        DemoAuthUserDO userObject = iDemoAuthUserService.getUserByUsername(userLoginDTO.getUsername());
        if(userObject!=null){
            log.info("用户存在，开始验证密码");
            //校验密码
            if(userObject.getPassword().equals(Md5Utils.MD5(userLoginDTO.getPassword()))){
                log.info("密码验证通过");
                //生成token
                String token = TokenUtil.createToken(userObject.getId(), userObject.getUsername());
                userLoginPO.setUserId(userObject.getId());
                userLoginPO.setUsername(userObject.getUsername());
                userLoginPO.setToken(token);

                //从缓存中获取用户ID
                String key = "user_" + userObject.getId();
                redisUtils.set(key, token,1296000);

                //插入缓存
                log.info("插入用户缓存 >> " + token);

                DemoAuthTokenDO demoAuthTokenDO = new DemoAuthTokenDO();
                demoAuthTokenDO.setUserId(userObject.getId());
                demoAuthTokenDO.setStatus(10);// 10 正常 110 过期
                demoAuthTokenDO.setToken(token);
                demoAuthTokenDO.setCreatedAt(new Date());
                demoAuthTokenDO.setUpdatedAt(new Date());
                iDemoAuthTokenService.createToken(demoAuthTokenDO);
                log.info("登录成功，并储存token成功");
                return ResponseDataUtil.buildSuccess(userLoginPO);
            }
            log.error("密码错误");
            return ResponseDataUtil.buildError("密码错误，请重新输入");
        }else{
            log.error("用户不存在");
            return ResponseDataUtil.buildError("用户不存在，请确认后再输入");
        }
    }
}
