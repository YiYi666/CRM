package com.zy.crm.service;

import com.zy.crm.entity.CustomerVisit;
import com.zy.crm.entity.Page;

public interface CustomerVisitService {
    Page<CustomerVisit> fingCustomerVisitPage(String pageNo);

    void addCustomerVisit(CustomerVisit customerVisit);

    void deleteCustomerVisitService(CustomerVisit visitId);


    CustomerVisit findCustomerVisitById(CustomerVisit customerVisit);
}
