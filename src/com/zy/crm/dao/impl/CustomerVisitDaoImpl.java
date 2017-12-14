package com.zy.crm.dao.impl;

import com.zy.crm.dao.CustomerVisitDao;
import com.zy.crm.entity.CustomerVisit;
import com.zy.crm.entity.Page;
import com.zy.crm.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CustomerVisitDaoImpl implements CustomerVisitDao {


    @Override
    public Integer findCount() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Long count = (long)session.createQuery("select count(visitId) from CustomerVisit").uniqueResult();
        session.getTransaction().commit();
        session.close();
        return count.intValue();
    }

    @Override
    public List<CustomerVisit> fingCustomerVisitPage(Page<CustomerVisit> page) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from CustomerVisit");
        query.setFirstResult(page.getBeginRow());
        query.setMaxResults(page.getPageSize());
        List<CustomerVisit> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void addCustomerVisit(CustomerVisit customerVisit) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(customerVisit);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteCustomerVisitService(CustomerVisit customerVisit) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        customerVisit = session.get(CustomerVisit.class, customerVisit.getVisitId());
        session.delete(customerVisit);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CustomerVisit findCustomerVisitById(CustomerVisit customerVisit) {
        Session session = HibernateUtil.getSession();
        customerVisit = session.get(CustomerVisit.class, customerVisit.getVisitId());
        session.close();
        return customerVisit;
    }
}
