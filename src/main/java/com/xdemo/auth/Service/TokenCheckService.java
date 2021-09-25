package com.xdemo.auth.Service;

import com.xdemo.auth.Utils.ResponseData;

public interface TokenCheckService {

    ResponseData checkToken(String token);

}
