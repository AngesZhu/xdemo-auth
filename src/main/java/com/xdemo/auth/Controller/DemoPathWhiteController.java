package com.xdemo.auth.Controller;


import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.xdemo.auth.Entity.DemoPathWhiteDO;
import com.xdemo.auth.Service.DemoAuthUserService;
import com.xdemo.auth.Service.DemoPathWhiteService;
import com.xdemo.auth.Utils.ResponseData;
import com.xdemo.auth.Utils.ResponseDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-24
 */
@RestController
@Api(tags = "PathWhite", description = "地址白名单相关接口", hidden=true)
@Slf4j
@RequestMapping("/api")
public class DemoPathWhiteController {

    @Autowired
    @Qualifier("DemoPathWhiteServiceBase")
    DemoPathWhiteService demoPathWhiteService;

    @ApiOperation(value="获取白名单列表", notes="获取白名单列表", produces="application/json")
    @GetMapping(value = "/paths")
    public ResponseData getPathList(){
        log.info("获取白名单列表");
        return ResponseDataUtil.buildSuccess(demoPathWhiteService.getPathWhites());
    }

    @ApiOperation(value="获取白名单信息", notes="获取白名单信息", produces="application/json")
    @GetMapping(value = "path/{id}")
    public ResponseData getPath(@PathVariable Integer id){
        log.info("获取白名单信息，" + id.toString());
        return ResponseDataUtil.buildSuccess(demoPathWhiteService.getPathWhiteById(id));
    }

    @ApiOperation(value="创建白名单", notes="创建白名单", produces="application/json")
    @PostMapping(value = "/path")
    public ResponseData createPath(@RequestBody DemoPathWhiteDO demoPathWhiteDO){
        log.info(String.format("创建白名单, %s", demoPathWhiteDO.getPath()));
        return ResponseDataUtil.buildSuccess(demoPathWhiteService.createPathWhite(demoPathWhiteDO));
    }

    @ApiOperation(value="更新白名单", notes="更新白名单", produces="application/json")
    @PutMapping(value = "path")
    public ResponseData updatePath(@RequestBody DemoPathWhiteDO demoPathWhiteDO){
        log.info(String.format("更新白名单, %s, %d", demoPathWhiteDO.getPath(), demoPathWhiteDO.getId()));
        return ResponseDataUtil.buildSuccess(demoPathWhiteService.updatePathWhite(demoPathWhiteDO));
    }

    @ApiOperation(value="删除白名单", notes="删除白名单", produces="application/json")
    @DeleteMapping(value = "path/{id}")
    public ResponseData deletePath(@PathVariable Integer id){
        log.info(String.format("删除白名单, %d", id));
        if(demoPathWhiteService.deletePathWhite(id)){
            return ResponseDataUtil.buildSuccess("删除成功");
        }else {
            return ResponseDataUtil.buildSuccess("删除失败");
        }
    }
}

