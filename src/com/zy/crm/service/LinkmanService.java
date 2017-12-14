package com.zy.crm.service;

import com.zy.crm.entity.Linkman;
import com.zy.crm.entity.Page;

public interface LinkmanService {
    void addLinkman(Linkman linkman);

    Page<Linkman> findPageLinkman(String lkmName, String pageNo);

    void deleteLinkman(Linkman linkman);

    void updateLinkman(Linkman linkman);

    Linkman findLinkmanById(Linkman linkman);
}
