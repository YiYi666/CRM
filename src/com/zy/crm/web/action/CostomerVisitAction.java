package com.zy.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.entity.Customer;
import com.zy.crm.entity.CustomerVisit;
import com.zy.crm.entity.Page;
import com.zy.crm.entity.User;
import com.zy.crm.service.CustomerService;
import com.zy.crm.service.CustomerVisitService;
import com.zy.crm.service.impl.CustomerServiceImpl;
import com.zy.crm.utils.SpringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;

public class CostomerVisitAction extends ActionSupport implements ModelDriven<CustomerVisit> {


    private String visitId;
    private Page<CustomerVisit> page = new Page<CustomerVisit>();
    private String pageNo;
    private String custId;
    private List<String> custIds;

    private CustomerService customerServiceImpl;


    private CustomerVisit customerVisit = new CustomerVisit();

    public CustomerVisit getCustomerVisit() {
        return customerVisit;
    }

    public void setCustomerVisit(CustomerVisit customerVisit) {
        this.customerVisit = customerVisit;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Page<CustomerVisit> getPage() {
        return page;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public List<String> getCustIds() {
        return custIds;
    }

    private CustomerVisitService customerVisitServiceImpl;

    public String list() throws Exception {
        customerVisitServiceImpl = (CustomerVisitService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerVisitService");
        page = customerVisitServiceImpl.fingCustomerVisitPage(pageNo);
        return "list";
    }
    public String addsubmit() throws Exception {
        customerVisitServiceImpl = (CustomerVisitService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerVisitService");
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        customerVisit.getUser().setUserId(user.getUserId());
        customerVisit.getCustomer().setCustId(Integer.parseInt(custId));
        customerVisitServiceImpl.addCustomerVisit(customerVisit);
        return "addsubmit";
    }

    public String delete() throws Exception {
        customerVisitServiceImpl = (CustomerVisitService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerVisitService");
        customerVisitServiceImpl.deleteCustomerVisitService(customerVisit);
        return "delete";
    }
    public String edit() throws Exception {
        customerVisitServiceImpl = (CustomerVisitService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerVisitService");
        customerVisit = customerVisitServiceImpl.findCustomerVisitById(customerVisit);
        //CustomerService customerServiceImpl = new CustomerServiceImpl();
        customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        custIds = customerServiceImpl.fingCustomerIds();
        return "edit";
    }



    @Override
    public CustomerVisit getModel() {
        return customerVisit;
    }
}
