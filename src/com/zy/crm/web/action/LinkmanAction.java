package com.zy.crm.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Linkman;
import com.zy.crm.entity.Page;
import com.zy.crm.service.CustomerService;
import com.zy.crm.service.LinkmanService;
import com.zy.crm.service.impl.CustomerServiceImpl;
import com.zy.crm.service.impl.LinkmanServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;


public class LinkmanAction implements ModelDriven {

 //   private LinkmanService LinkmanServiceImpl = new LinkmanServiceImpl();
    private LinkmanService LinkmanServiceImpl;
    private Linkman linkman = new Linkman();
    private Page<Linkman> page = new Page<>();
    private String pageNo;
    private String custId;
    private List<String> custIds;
    private CustomerService customerServiceImpl;

    public String addsubmit() throws Exception {
        LinkmanServiceImpl = (LinkmanService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("linkmanService");
        linkman.getCustomer().setCustId(Integer.parseInt(custId));
        LinkmanServiceImpl.addLinkman(linkman);
        return "addsubmit";
    }
    public String list() throws Exception {
        LinkmanServiceImpl = (LinkmanService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("linkmanService");
        page = LinkmanServiceImpl.findPageLinkman(linkman.getLkmName(),pageNo);
        return "list";
    }
    public String delete() throws Exception {
        LinkmanServiceImpl = (LinkmanService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("linkmanService");
        LinkmanServiceImpl.deleteLinkman(linkman);
        return "delete";
    }
    public String editsubmit() throws Exception {
        LinkmanServiceImpl = (LinkmanService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("linkmanService");
        linkman.getCustomer().setCustId(Integer.parseInt(custId));
        LinkmanServiceImpl.updateLinkman(linkman);
        return "editsubmit";
    }
    public String edit() throws Exception {
        LinkmanServiceImpl = (LinkmanService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("linkmanService");
        linkman = LinkmanServiceImpl.findLinkmanById(linkman);
        customerServiceImpl = (CustomerService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("customerService");
        custIds = customerServiceImpl.fingCustomerIds();
        return "edit";
    }

    public void setLinkman(Linkman linkman) {
        this.linkman = linkman;
    }

    public Linkman getLinkman() {
        return linkman;
    }

    @Override
    public Object getModel() {
        return linkman;
    }


    public Page<Linkman> getPage() {
        return page;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }


    public void setCustId(String custId) {
        this.custId = custId;
    }
    public List<String> getCustIds() {
        return custIds;
    }
}
