package com.xdemo.auth.Service;

import com.xdemo.auth.Definition.Pojo.UserLoginDTO;
import com.xdemo.auth.Utils.ResponseData;

/**
 * <p>
 *  登录类
 * </p>
 *
 * @author LiMeng
 * @since 2021-04-30
 */
public interface LoginInService {
    ResponseData loginIn(UserLoginDTO userLoginDTO);
}
