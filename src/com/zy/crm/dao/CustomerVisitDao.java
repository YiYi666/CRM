package com.zy.crm.dao;

import com.zy.crm.entity.CustomerVisit;
import com.zy.crm.entity.Page;

import java.util.List;

public interface CustomerVisitDao {

    Integer findCount();

    List<CustomerVisit> fingCustomerVisitPage(Page<CustomerVisit> page);

    void addCustomerVisit(CustomerVisit customerVisit);

    void deleteCustomerVisitService(CustomerVisit visitId);

    CustomerVisit findCustomerVisitById(CustomerVisit customerVisit);
}
