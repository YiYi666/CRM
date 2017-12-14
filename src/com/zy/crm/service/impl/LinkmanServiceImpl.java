package com.zy.crm.service.impl;

import com.zy.crm.dao.LinkmanDao;
import com.zy.crm.dao.impl.LinkmanDaoImpl;
import com.zy.crm.entity.Linkman;
import com.zy.crm.entity.Page;
import com.zy.crm.service.LinkmanService;

import java.util.List;

public class LinkmanServiceImpl implements LinkmanService {
    //private LinkmanDao linkmanDao = new LinkmanDaoImpl();
    private LinkmanDao linkmanDao;

    public void setLinkmanDao(LinkmanDao linkmanDao) {
        this.linkmanDao = linkmanDao;
    }

    @Override
    public void addLinkman(Linkman linkman) {

        linkmanDao.addLinkman(linkman);
    }

    @Override
    public void deleteLinkman(Linkman linkman) {

        linkmanDao.deleteLinkman(linkman);
    }

    @Override
    public Page<Linkman> findPageLinkman(String lkmName, String pageNo) {

        Integer pageSize = 1;
        Integer count = linkmanDao.findLinkmanCount(lkmName);
        Page<Linkman> page = new Page<Linkman>(pageNo,pageSize,count);
        List<Linkman> list = linkmanDao.findPageLinkman(page,lkmName);
        page.setDatas(list);
        return page;
    }

    @Override
    public void updateLinkman(Linkman linkman) {
        linkmanDao.updateLinkman(linkman);
    }

    @Override
    public Linkman findLinkmanById(Linkman linkman) {
        linkman = linkmanDao.findLinkmanById(linkman);
        return linkman;
    }
}
