package com.xdemo.auth.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xdemo.auth.Definition.Pojo.UserSearchDTO;
import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */

public interface DemoAuthUserMapper extends BaseMapper<DemoAuthUserDO> {
    IPage<DemoAuthUserDO> pageDataSource(IPage<DemoAuthUserDO> page, @Param("UserSearchDTO") UserSearchDTO userSearchDTO);

}
