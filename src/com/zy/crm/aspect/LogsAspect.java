package com.zy.crm.aspect;

import com.opensymphony.xwork2.ActionContext;
import com.zy.crm.dao.CustomerDao;
import com.zy.crm.dao.LogsAspectDao;
import com.zy.crm.dao.UserDao;
import com.zy.crm.dao.impl.LogsAspectDaoImpl;
import com.zy.crm.dao.impl.UserDaoImpl;
import com.zy.crm.entity.Logs;
import com.zy.crm.entity.User;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//@Component("logsAspect")
//@Aspect
public class LogsAspect {

    //@Resource
    private LogsAspectDao logsAspectDao /*= new LogsAspectDaoImpl()*/;

    //@Resource
    private UserDao userDao /*= new UserDaoImpl()*/;

    public void setLogsAspectDao(LogsAspectDao logsAspectDao) {
        this.logsAspectDao = logsAspectDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private Logs logs = new Logs();

    public void setLogs(Logs logs) {
        this.logs = logs;
    }
    //@Pointcut(value = "execution(public * *.*(..)) and !execution(public * com.zy.crm.service.impl.UserServiceImpl.login(..)) ")
 //   private void anydao(){}

  // @Around(value = "anydao()")
    public Object around(ProceedingJoinPoint pjp) throws Exception{
         Signature signature = pjp.getSignature();
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User)request.getSession().getAttribute("user");
        user = userDao.findUserByUserCode(user.getUserCode());
        logs.setUser(user);
        logs.setDate(new Date());
        logs.setRemark(signature.getName());
        Object result = null;
        System.out.println("之前");
        try {
            result = pjp.proceed();

            logsAspectDao.logs(logs);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("报错");
        }finally {
            System.out.println("最终");
        }
        return result;
    }

}
