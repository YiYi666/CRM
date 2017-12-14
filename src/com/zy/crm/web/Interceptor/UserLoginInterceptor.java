package com.zy.crm.web.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zy.crm.entity.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class UserLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "loginInterceptor";
        }
        return actionInvocation.invoke();
    }
}
