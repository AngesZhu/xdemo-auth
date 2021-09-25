package com.xdemo.auth.Repository;

import com.xdemo.auth.Entity.DemoAuthTokenDO;
import com.xdemo.auth.Entity.DemoPathWhiteDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-24
 */
public interface DemoPathWhiteMapper extends BaseMapper<DemoPathWhiteDO> {

}
