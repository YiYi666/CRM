package com.zy.crm.dao;

import com.zy.crm.entity.Linkman;
import com.zy.crm.entity.Page;

import java.util.List;

public interface LinkmanDao {
    void addLinkman(Linkman linkman);

    Integer findLinkmanCount(String lkmName);

    List<Linkman> findPageLinkman(Page<Linkman> page, String lkmName);

    void deleteLinkman(Linkman linkman);

    void updateLinkman(Linkman linkman);

    Linkman findLinkmanById(Linkman linkman);
}
