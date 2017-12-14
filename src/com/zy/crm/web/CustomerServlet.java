package com.zy.crm.web;

import com.zy.crm.entity.Customer;
import com.zy.crm.entity.Page;
import com.zy.crm.service.CustomerService;
import com.zy.crm.service.impl.CustomerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//@WebServlet("/customerServlet")
public class CustomerServlet extends BaseServlet {
    private CustomerService customerServiceImpl = new CustomerServiceImpl();
    public String add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {

        String method = request.getParameter("method");


        Map<String, String[]> parameterMap = request.getParameterMap();
        Customer customer = new Customer();
        BeanUtils.populate(customer,parameterMap);
        boolean flag = customerServiceImpl.addCustomer(customer);
        if (flag){
            return "Redirect:customerServlet?method=list";
        }else {
            response.getWriter().write("添加失败！");
            return "msg";
        }

    }

    public String list(HttpServletRequest request, HttpServletResponse response){

        String pageNo = request.getParameter("page");
        Page page = customerServiceImpl.fingCustomerPage(pageNo);
        request.setAttribute("page",page);
        return  "jsp/customer/list";
    }
    public String delete(HttpServletRequest request, HttpServletResponse response){

        String custId = request.getParameter("custId");
        customerServiceImpl.deleteCustomer(custId);
        return "Redirect:customerServlet?method=list";
    }
    public String edit(HttpServletRequest request, HttpServletResponse response){
        String custId = request.getParameter("custId");
        Customer customer = customerServiceImpl.findCustomerById(custId);
        request.setAttribute("customer",customer);
        return "jsp/customer/edit";
    }
    public String editsubmit(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Customer customer = new Customer();
        BeanUtils.populate(customer,parameterMap);
        customerServiceImpl.updateCustomer(customer);
        return "Redirect:customerServlet?method=list";
    }
}
