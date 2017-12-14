package com.zy.crm.service.impl;

import com.zy.crm.dao.UserDao;
import com.zy.crm.dao.impl.UserDaoImpl;
import com.zy.crm.entity.User;
import com.zy.crm.service.UserService;

public class UserServiceImpl implements UserService {

 //   private UserDao userDao = new UserDaoImpl();
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(User user) {
        User u = userDao.login(user);
        return u;
    }
}
