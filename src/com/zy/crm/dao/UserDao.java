package com.zy.crm.dao;

import com.zy.crm.entity.User;


public interface UserDao {
    User login(User user);
    public User findUserByUserCode(String userCode);
}
