package com.xdemo.auth.Service.impl;

import com.xdemo.auth.Service.DemoAuthTokenService;
import com.xdemo.auth.Service.LogoutService;
import com.xdemo.auth.Utils.ResponseData;
import com.xdemo.auth.Utils.ResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service("LogoutServiceBase")
public class LogoutServiceImpl implements LogoutService {

//    @Autowired
//    LogoutService logoutService;

    @Autowired
    @Qualifier("DemoAuthTokenServiceBase")
    DemoAuthTokenService iDemoAuthTokenService;

    @Override
    public ResponseData loginOut(String token) {
        try {
//            log.info("根据token获取用户对象");
//            DemoAuthTokenDO demoAuthTokenDO = iDemoAuthTokenService.checkUserByToken(token);
//            log.info("根据用户信息，对当前用户所有token进行无效处理，以用来保证一用户只有一个token正常");
//            Integer user_id = demoAuthTokenDO.getUserId();
//            iDemoAuthTokenService.deleteTokenByUserId(user_id, new Date());
            log.info("更新token状态");
            iDemoAuthTokenService.deleteTokenByToken(token, new Date());
            log.info("登出成功");
            return ResponseDataUtil.buildSuccess("登出成功");
        } catch (Exception e){
            e.printStackTrace();
            log.error("登出失败");
            return ResponseDataUtil.buildError("登出失败，请稍后重试");
        }
    }
}
