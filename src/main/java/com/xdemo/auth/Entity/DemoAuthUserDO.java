package com.xdemo.auth.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("demo_auth_user")
public class DemoAuthUserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //用户名
    private String username;
    //密码
    //@JsonIgnore
    private String password;
    //是否是超级管理员
//    @JsonIgnore
    private Boolean isSuperuser = false;
    //名
    private String firstName;
    //姓氏
    private String lastName;
    //电子邮件
    private String email;
    //手机号码
    private String phone;
    //是否活跃用户
    private Boolean isActive = true;

}
