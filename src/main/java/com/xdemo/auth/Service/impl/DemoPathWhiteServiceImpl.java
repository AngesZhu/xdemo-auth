package com.xdemo.auth.Service.impl;

import com.xdemo.auth.Entity.DemoPathWhiteDO;
import com.xdemo.auth.Repository.DemoPathWhiteMapper;
import com.xdemo.auth.Service.DemoPathWhiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-24
 */
@Service("DemoPathWhiteServiceBase")
@Primary
public class DemoPathWhiteServiceImpl extends ServiceImpl<DemoPathWhiteMapper, DemoPathWhiteDO> implements DemoPathWhiteService {

    @Autowired
    DemoPathWhiteMapper demoPathWhiteMapper;

    @Override
    public List<DemoPathWhiteDO> getPathWhites() {
        return demoPathWhiteMapper.selectList(null);
    }

    @Override
    public DemoPathWhiteDO getPathWhiteById(int id) {
        return demoPathWhiteMapper.selectById(id);
    }

    @Override
    public boolean deletePathWhite(int id) {
        demoPathWhiteMapper.deleteById(id);
        return true;
    }

    @Override
    public Integer updatePathWhite(DemoPathWhiteDO demoPathWhiteDO) {
        return demoPathWhiteMapper.updateById(demoPathWhiteDO);
    }

    @Override
    public DemoPathWhiteDO createPathWhite(DemoPathWhiteDO demoPathWhiteDO) {
        demoPathWhiteMapper.insert(demoPathWhiteDO);
        return demoPathWhiteDO;
    }
}
