package com.xdemo.auth.Controller;

import com.xdemo.auth.Definition.Pojo.NumChangeChineseDTO;
import com.xdemo.auth.Definition.Pojo.NumChangeChinesePO;
import com.xdemo.auth.Definition.Pojo.UserLoginDTO;
import com.xdemo.auth.Service.LoginInService;
import com.xdemo.auth.Service.LogoutService;
import com.xdemo.auth.Utils.ResponseData;
import com.xdemo.auth.Utils.ResponseDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiMeng
 * @since 2021-04-29
 */
@Slf4j
@RestController
@Api(tags = "login", description = "用户相关接口", hidden=true)
@RequestMapping("/api")
public class LoginController {

    @Autowired
    @Qualifier("LoginInServiceBase")
    LoginInService loginInService;

    @Autowired
    @Qualifier("LogoutServiceBase")
    LogoutService logoutService;

    @ApiOperation(value="登录接口", notes="登录接口", produces="application/json")
    @PostMapping(value = "/login")
    public ResponseData loginIn(@RequestBody UserLoginDTO userLoginDTO){
        if(true){
            String a = "aaa";
        }else {
            String a = "bbb";
        }
        log.info("用户登录，" + userLoginDTO.getUsername());
        return loginInService.loginIn(userLoginDTO);
    }

    @ApiOperation(value="登出接口", notes="登出接口", produces="application/json")
    @PostMapping(value = "/logout")
    public ResponseData loginOut(@RequestHeader("X-Token") String token){
        if(true){
            String a = "aaa";
        }else {
            String a = "bbb";
        }
        log.info("用户登出，登出token：" + token);
        return logoutService.loginOut(token);
    }
}
