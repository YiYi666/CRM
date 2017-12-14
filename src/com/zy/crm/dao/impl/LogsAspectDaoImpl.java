package com.zy.crm.dao.impl;

import com.zy.crm.dao.LogsAspectDao;
import com.zy.crm.entity.Logs;
import com.zy.crm.utils.HibernateUtil;
import org.hibernate.Session;

public class LogsAspectDaoImpl implements LogsAspectDao {

    @Override
    public void logs(Logs logs) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.save(logs);
        session.getTransaction().commit();
        session.close();
    }
}
