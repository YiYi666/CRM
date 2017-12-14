package com.zy.crm.dao.impl;

import com.zy.crm.dao.UserDao;
import com.zy.crm.entity.User;
import com.zy.crm.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from User u where u.userCode=:code and u.userPwd=:pwd and u.userState = 1");
        query.setParameter("code",user.getUserCode());
        query.setParameter("pwd",user.getUserPwd());
        User u = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public User findUserByUserCode(String userCode) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from User u where u.userCode=:code");
        query.setParameter("code",userCode);
        User u = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return u;
    }

}
