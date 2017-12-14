package com.zy.crm.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
    private static ApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    public static Object getBean(String id){
        return context.getBean(id);
    }
}
