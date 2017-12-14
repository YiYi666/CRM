package com.zy.crm.dao;

import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Page;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);

    Integer findCount();

    List<Customer> fingCustomerPage(Page<Customer> page);

    void deleteCustomer(Customer customer);

    Customer findCustomerById(String custId);

    void updateCustomer(Customer customer);

    List fingCustomerIds();
}
