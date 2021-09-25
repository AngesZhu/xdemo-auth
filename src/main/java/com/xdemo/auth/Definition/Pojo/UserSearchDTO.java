package com.xdemo.auth.Definition.Pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class UserSearchDTO implements Serializable{

        private Integer page;
        private Integer limit;

        private Integer id = null;
        //用户名
        private String username = null;
        //名
        private String firstName = null;
        //姓氏
        private String lastName = null;
        //电子邮件
        private String email = null;
        //手机号码
        private String phone = null;
}
