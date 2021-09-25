package com.xdemo.auth.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xdemo.auth.Definition.Pojo.UserSearchDTO;
import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
public interface DemoAuthUserService extends IService<DemoAuthUserDO> {

    List<DemoAuthUserDO> getUsers();

    IPage<DemoAuthUserDO> getUserByPage(UserSearchDTO userSearchDTO);

    DemoAuthUserDO getUserByUsername(String username);

    DemoAuthUserDO getUserById(int id);

    boolean deleteUser(int id);

    Integer updateUser(DemoAuthUserDO userObject);

    DemoAuthUserDO createUser(DemoAuthUserDO userObject);
}
