package com.zy.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Page;
import com.zy.crm.service.CustomerService;
import com.zy.crm.service.impl.CustomerServiceImpl;
import com.zy.crm.utils.SpringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import java.util.List;


@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{


    private Page<Customer> page = new Page<Customer>();
    private String pageNo;
    private Customer customer = new Customer();
    private List<String> custIds;


    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    //private CustomerService customerServiceImpl = new CustomerServiceImpl();

    @Resource
    private CustomerService customerServiceImpl;

    public String list() throws Exception {
        //customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        //customerServiceImpl = (CustomerService) SpringUtils.getBean("customerService");
        page = customerServiceImpl.fingCustomerPage(pageNo);
        return "list";
    }
    public String listForId() throws Exception {
       // customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        custIds = customerServiceImpl.fingCustomerIds();
        return "listForId";
    }
    public String listForVisitId() throws Exception {
        //customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        custIds = customerServiceImpl.fingCustomerIds();
        return "listForVisitId";
    }

    public String add() throws Exception {
        //customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        customerServiceImpl.addCustomer(customer);
        return "add";
    }
    public String edit() throws Exception {
        //customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        customer = customerServiceImpl.findCustomerById(customer.getCustId()+"");
        return "edit";
    }
    public String editsubmit() throws Exception {
       // customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        customerServiceImpl.updateCustomer(customer);
        return "editsubmit";
    }
    public String delete() throws Exception {
       // customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        customerServiceImpl.deleteCustomer(customer.getCustId()+"");
        return "delete";
    }



    public Page<Customer> getPage() {
        return page;
    }

    public void setPage(Page<Customer> page) {
        this.page = page;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<String> getCustIds() {
        return custIds;
    }
}
