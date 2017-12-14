package com.zy.crm.service.impl;

import com.zy.crm.dao.CustomerVisitDao;
import com.zy.crm.entity.CustomerVisit;
import com.zy.crm.entity.Page;
import com.zy.crm.service.CustomerVisitService;

import java.util.List;

public class CustomerVisitServiceImpl implements CustomerVisitService {



    private CustomerVisitDao customerVisitDao;

    @Override
    public Page<CustomerVisit> fingCustomerVisitPage(String pageNo) {
        Integer count = customerVisitDao.findCount();
        Integer pageSize = 1;
        Page<CustomerVisit> page = new Page<CustomerVisit>(pageNo, pageSize, count);
        List<CustomerVisit> list = customerVisitDao.fingCustomerVisitPage(page);
        page.setDatas(list);
        return page;
    }

    @Override
    public void addCustomerVisit(CustomerVisit customerVisit) {
        customerVisitDao.addCustomerVisit(customerVisit);
    }

    @Override
    public void deleteCustomerVisitService(CustomerVisit customerVisit) {
        customerVisitDao.deleteCustomerVisitService(customerVisit);
    }

    @Override
    public CustomerVisit findCustomerVisitById(CustomerVisit customerVisit) {
        customerVisit = customerVisitDao.findCustomerVisitById(customerVisit);
        return customerVisit;
    }

    public void setCustomerVisitDao(CustomerVisitDao customerVisitDao) {
        this.customerVisitDao = customerVisitDao;
    }
}
