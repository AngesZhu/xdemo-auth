package com.xdemo.auth.Controller;


import com.xdemo.auth.Service.TokenCheckService;
import com.xdemo.auth.Utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
@Slf4j
@RestController
@Api(tags = "token", description = "token相关接口", hidden=true)
@RequestMapping("/api")
public class DemoAuthTokenController {

    @Autowired
    @Qualifier("TokenCheckService")
    TokenCheckService tokenCheckService;

    @ApiOperation(value="token验证", notes="token验证", produces="application/json")
    @GetMapping(value = "/checkToken")
    public ResponseData checkToken(@RequestHeader("X-Token") String token){
        return tokenCheckService.checkToken(token);
    }

}

