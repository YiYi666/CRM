package com.zy.crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        //默认加载src目录下的配置文件
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public static Session getSession(){
        //返回session对象
        return sessionFactory.openSession();
    }
}
