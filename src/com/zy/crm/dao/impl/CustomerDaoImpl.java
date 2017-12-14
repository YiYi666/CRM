package com.zy.crm.dao.impl;

import com.zy.crm.dao.CustomerDao;
import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Page;
import com.zy.crm.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer findCustomerById(String custId) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Customer customer = session.get(Customer.class, Integer.parseInt(custId));
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Integer findCount() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Long count = (long)session.createQuery("select count(custId) from Customer").uniqueResult();
        session.getTransaction().commit();
        session.close();
        return count.intValue();
    }

    @Override
    public List<Customer> fingCustomerPage(Page<Customer> page) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Customer");
        query.setFirstResult(page.getBeginRow());
        query.setMaxResults(page.getPageSize());
        List<Customer> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List fingCustomerIds() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select custId from Customer");
        List list = query.list();
        session.close();
        return list;
    }
}
