package com.xdemo.auth.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@TableName("demo_auth_token")
public class DemoAuthTokenDO implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String token;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;


}
