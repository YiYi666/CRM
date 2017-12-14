package com.zy.crm.service;

import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Page;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer);

    Page fingCustomerPage(String pageNo);

    void deleteCustomer(String custId);

    Customer findCustomerById(String custId);

    void updateCustomer(Customer customer);


    List fingCustomerIds();
}
