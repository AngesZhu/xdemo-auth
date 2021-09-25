package com.xdemo.auth.Service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xdemo.auth.Definition.Pojo.UserSearchDTO;
import com.xdemo.auth.Entity.DemoAuthUserDO;
import com.xdemo.auth.Repository.DemoAuthUserMapper;
import com.xdemo.auth.Service.DemoAuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdemo.auth.Utils.PassWordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiMeng
 * @since 2021-05-17
 */
@Service("DemoAuthUserServiceBase")
@Primary
public class DemoAuthUserServiceImpl extends ServiceImpl<DemoAuthUserMapper, DemoAuthUserDO> implements DemoAuthUserService {

    @Autowired
    DemoAuthUserMapper demoAuthUserMapper;

    @Override
    public List<DemoAuthUserDO> getUsers() {
        return demoAuthUserMapper.selectList(null);
    }

    @Override
    public IPage<DemoAuthUserDO> getUserByPage(UserSearchDTO userSearchDTO) {
        Page<DemoAuthUserDO> page = new Page<>(userSearchDTO.getPage(), userSearchDTO.getLimit());
        return demoAuthUserMapper.pageDataSource(page, userSearchDTO);
    }

    @Override
    public DemoAuthUserDO getUserById(int id){
        return demoAuthUserMapper.selectById(id);
    }

    @Override
    public DemoAuthUserDO getUserByUsername(String username){
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        List<DemoAuthUserDO> search = demoAuthUserMapper.selectByMap(map);
        if(search.size()==0){
            return null;
        }else {
            return search.get(0);
        }
    }

    @Override
    public boolean deleteUser(int id){
        demoAuthUserMapper.deleteById(id);
        return true;
    }

    @Override
    public Integer updateUser(DemoAuthUserDO demoAuthUserDO){

        return demoAuthUserMapper.updateById(demoAuthUserDO);
    }

    @Override
    public DemoAuthUserDO createUser(DemoAuthUserDO demoAuthUserDO){
        String password = demoAuthUserDO.getPassword();
        demoAuthUserDO.setPassword(PassWordUtils.encryptMD5(password));
        demoAuthUserMapper.insert(demoAuthUserDO);
        return demoAuthUserDO;
    }
}
