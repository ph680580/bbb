package com.ph.vuelx03.dao;

import com.github.pagehelper.Page;
import com.ph.vuelx03.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Page<User> list(String username);

    void add(User user);

    void delAll(Integer[] userids);

}