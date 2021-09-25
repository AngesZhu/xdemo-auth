package com.xdemo.auth.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xdemo.auth.Entity.DemoPathWhiteDO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-24
 */
public interface DemoPathWhiteService extends IService<DemoPathWhiteDO> {

    List<DemoPathWhiteDO> getPathWhites();

    DemoPathWhiteDO getPathWhiteById(int id);

    boolean deletePathWhite(int id);

    Integer updatePathWhite(DemoPathWhiteDO userObject);

    DemoPathWhiteDO createPathWhite(DemoPathWhiteDO userObject);

}
