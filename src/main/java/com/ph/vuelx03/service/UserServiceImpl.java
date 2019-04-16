package com.ph.vuelx03.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.ph.vuelx03.dao.UserMapper;
import com.ph.vuelx03.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> list(String username) {
        return userMapper.list(username);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void updateByPrimaryKey(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteByPrimaryKey(Integer userid) {
        userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public void delAll(Integer[] userids) {
        userMapper.delAll(userids);
    }


}
