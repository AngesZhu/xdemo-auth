package com.xdemo.auth.Service;

import com.xdemo.auth.Utils.ResponseData;

public interface LogoutService {

    ResponseData loginOut(String token);
}
