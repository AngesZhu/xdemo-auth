package com.xdemo.auth.Controller;


import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.xdemo.auth.Service.DemoAuthUserService;
import com.xdemo.auth.Utils.ResponseData;
import com.xdemo.auth.Utils.ResponseDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@Api(tags = "User", description = "用户相关接口", hidden=true)
@RequestMapping("/api")
public class DemoAuthUserController {

    @Autowired
    //@Resource(name = "DemoAuthUserService")
    @Qualifier("DemoAuthUserServiceBase")
    DemoAuthUserService iDemoAuthUserService;

    @ApiOperation(value="获取用户列表", notes="获取用户列表", produces="application/json")
    @GetMapping(value = "/users")
    public ResponseData getUserList(){
        log.info("获取用户列表");
//    public ResponseData getUserList(UserSearchDTO userSearchDTO){
//        return ResponseDataUtil.buildSuccess(iDemoAuthUserService.getUserByPage(userSearchDTO));
        return ResponseDataUtil.buildSuccess(iDemoAuthUserService.getUsers());
    }

    @ApiOperation(value="获取用户信息", notes="获取用户信息", produces="application/json")
    @GetMapping(value = "user/{id}")
    public ResponseData getUser(@PathVariable Integer id){
        log.info("获取用户信息，" + id.toString());
        return ResponseDataUtil.buildSuccess(iDemoAuthUserService.getUserById(id));
    }

    @ApiOperation(value="创建用户", notes="创建用户", produces="application/json")
    @PostMapping(value = "/user")
    public ResponseData createUser(@RequestBody DemoAuthUserDO demoAuthUserDO){
        log.info(String.format("创建用户, %s", demoAuthUserDO.getUsername()));
        return ResponseDataUtil.buildSuccess(iDemoAuthUserService.createUser(demoAuthUserDO));
    }

    @ApiOperation(value="更新用户", notes="更新用户", produces="application/json")
    @PutMapping(value = "user")
    public ResponseData updateUser(@RequestBody DemoAuthUserDO demoAuthUserDO){
        log.info(String.format("更新用户, %s, %d", demoAuthUserDO.getUsername(), demoAuthUserDO.getId()));
        return ResponseDataUtil.buildSuccess(iDemoAuthUserService.updateUser(demoAuthUserDO));
    }

    @ApiOperation(value="删除用户", notes="删除用户", produces="application/json")
    @DeleteMapping(value = "user/{id}")
    public ResponseData deleteUser(@PathVariable Integer id){
        log.info(String.format("删除用户, %d", id));
        if(iDemoAuthUserService.deleteUser(id)){
            return ResponseDataUtil.buildSuccess("删除成功");
        }else {
            return ResponseDataUtil.buildSuccess("删除失败");
        }
    }
}

