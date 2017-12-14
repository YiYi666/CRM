package com.zy.crm.dao.impl;

import com.zy.crm.dao.LinkmanDao;
import com.zy.crm.entity.Linkman;
import com.zy.crm.entity.Page;
import com.zy.crm.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class LinkmanDaoImpl implements LinkmanDao {

    @Override
    public void deleteLinkman(Linkman linkman) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Linkman l = session.get(Linkman.class, linkman.getLkmId());
        session.delete(l);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addLinkman(Linkman linkman) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.save(linkman);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Integer findLinkmanCount(String lkmName) {
        Session session = HibernateUtil.getSession();
        String hql = "select count(lkmId) from Linkman where 1=1";
        if(lkmName!=null){
            hql+=" and lkmName like :name";
        }
        Query query = session.createQuery(hql);
        if(lkmName!=null ){
            query.setParameter("name","%"+lkmName+"%");
        }
        Long num = (long) query.uniqueResult();
        Integer count = num.intValue();
        session.close();
        return count;
    }

    @Override
    public List<Linkman> findPageLinkman(Page<Linkman> page, String lkmName) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from Linkman where 1=1";
        if(lkmName!=null){
            hql+=" and lkmName like :name";
        }
        Query query = session.createQuery(hql);
        if(lkmName!=null){
            query.setParameter("name","%"+lkmName+"%");
        }
        query.setFirstResult(page.getBeginRow());
        query.setMaxResults(page.getPageSize());
        List<Linkman> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void updateLinkman(Linkman linkman) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(linkman);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Linkman findLinkmanById(Linkman linkman) {
        Session session = HibernateUtil.getSession();
        linkman = session.get(Linkman.class,linkman.getLkmId());
        session.close();
        return linkman;
    }
}
