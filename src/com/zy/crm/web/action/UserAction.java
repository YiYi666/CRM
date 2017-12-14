package com.zy.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.entity.User;
import com.zy.crm.service.UserService;
import com.zy.crm.service.impl.UserServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class UserAction extends ActionSupport implements ModelDriven{
    private User user = new User();

//    private UserService userService = new UserServiceImpl();
    private UserService userService;
    public String login() throws Exception{
        userService = (UserService) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()).getBean("userService");
        User u = userService.login(user);
        if(null!=u){
            ServletActionContext.getRequest().getSession().setAttribute("user",u);
        }
        return "login";
    }

    @Override
    public Object getModel() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
