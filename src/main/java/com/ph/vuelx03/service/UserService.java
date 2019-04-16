package com.ph.vuelx03.service;

import com.github.pagehelper.Page;
import com.ph.vuelx03.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    Page<User> list(String username);

    void add(User user);

    User selectByPrimaryKey(Integer userId);

    void updateByPrimaryKey(User user);

    void deleteByPrimaryKey(@Param("userId") Integer userid);

    void delAll(Integer[] userids);
}
