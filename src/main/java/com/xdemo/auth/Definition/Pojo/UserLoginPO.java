package com.xdemo.auth.Definition.Pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserLoginPO {

    private Integer userId;

    private String username;

    private String token;
}
