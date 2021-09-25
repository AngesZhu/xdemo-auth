package com.xdemo.auth.Service.impl;

import com.xdemo.auth.Entity.DemoAuthTokenDO;
import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.xdemo.auth.Service.DemoAuthTokenService;
import com.xdemo.auth.Service.DemoAuthUserService;
import com.xdemo.auth.Service.TokenCheckService;
import com.xdemo.auth.Utils.ResponseData;
import com.xdemo.auth.Utils.ResponseDataUtil;
import com.xdemo.auth.Utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("TokenCheckService")
@Slf4j
public class TokenCheckServiceImpl implements TokenCheckService {

    @Autowired
    @Qualifier("DemoAuthTokenServiceBase")
    DemoAuthTokenService iDemoAuthTokenService;

    @Autowired
    @Qualifier("DemoAuthUserServiceBase")
    DemoAuthUserService iDemoAuthUserService;

    @Override
    public ResponseData checkToken(String token) {
        log.info("验证token");
        boolean object = TokenUtil.checkToken(token);
        if(object){
            log.info("token未过期");
            log.info("获取已存入的token对象");
            DemoAuthTokenDO demoAuthTokenDO = iDemoAuthTokenService.checkUserByToken(token);
            if (10 == demoAuthTokenDO.getStatus()) {
                log.info("token状态正常，获取用户信息");
                DemoAuthUserDO demoAuthUserDO = iDemoAuthUserService.getUserById(demoAuthTokenDO.getUserId());
                log.info("token验证通过");
                return ResponseDataUtil.buildSuccess("token验证通过", demoAuthUserDO);
            }
            log.error("token验证失败，此token已注销");
            return ResponseDataUtil.buildError("token验证失败，此token已注销");
        }
        log.error("token验证失败，此token已过期");
        return ResponseDataUtil.buildError("token验证失败，此token已过期");
    }
}
