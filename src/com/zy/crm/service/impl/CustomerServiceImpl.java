package com.zy.crm.service.impl;

import com.zy.crm.dao.CustomerDao;
import com.zy.crm.dao.impl.CustomerDaoImpl;
import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Page;
import com.zy.crm.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

 //   private CustomerDao customerDaoImpl = new CustomerDaoImpl();
    @Resource
    private CustomerDao customerDaoImpl;

    public void setCustomerDaoImpl(CustomerDao customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }

    @Override
    public boolean addCustomer(Customer customer) {


        try {
            customerDaoImpl.addCustomer(customer);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Page fingCustomerPage(String pageNo) {

        Integer count = customerDaoImpl.findCount();
        Integer pageSize = 15;
        Page<Customer> page = new Page<>(pageNo, pageSize, count);
        List<Customer>  list = customerDaoImpl.fingCustomerPage(page);
        page.setDatas(list);
        return page;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDaoImpl.updateCustomer(customer);
    }

    @Override
    public List fingCustomerIds() {
        List custIds = customerDaoImpl.fingCustomerIds();
        return custIds;
    }

    @Override
    public Customer findCustomerById(String custId) {
        Customer customer = customerDaoImpl.findCustomerById(custId);
        return customer;
    }

    @Override
    public void deleteCustomer(String custId) {
        Customer customer = new Customer();
        customer.setCustId(Integer.parseInt(custId));
        customerDaoImpl.deleteCustomer(customer);
    }
}
