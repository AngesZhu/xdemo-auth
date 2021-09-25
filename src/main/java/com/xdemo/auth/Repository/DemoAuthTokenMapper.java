package com.xdemo.auth.Repository;

import com.xdemo.auth.Entity.DemoAuthTokenDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
public interface DemoAuthTokenMapper extends BaseMapper<DemoAuthTokenDO> {
    @Update("update demo_auth_token set status = 110, updated_at = #{updated_at} where user_id = #{user_id} and status = 10;")
    void deleteTokenByUserId(@Param("user_id") Integer user_id, @Param("updated_at") Date updated_at);

    @Update("update demo_auth_token set status = 110, updated_at = #{updated_at} where token = #{token};")
    void deleteTokenByToken(@Param("token") String token, @Param("updated_at") Date updated_at);

    //@Select("select * from demo_auth_token where token = #{token} and status = 10;")
    @Select("select * from demo_auth_token where token = #{token};")
    DemoAuthTokenDO checkUserByToken(@Param("token") String token);

}
