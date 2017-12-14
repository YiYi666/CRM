package com.zy.crm.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String mothod = req.getParameter("method");
		System.out.println(mothod);
		if(null!=mothod && (!mothod.isEmpty()) ) {
			try {
				Class<?> clzz = Class.forName(this.getClass().getName());
				Method method = clzz.getMethod(mothod, HttpServletRequest.class,HttpServletResponse.class);
				String result = (String) method.invoke(this,req, resp);
				if(result !=null) {
					if(result.contains("Redirect:")) {
						result = result.replaceAll("Redirect:", "");
						resp.sendRedirect(result);
					}else {
						req.getRequestDispatcher("/"+ result +".jsp").forward(req, resp);;
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}else {
			doGet(req,resp);
			//PrintWriter writer = resp.getWriter();
			//writer.write("no!");
		}
		
	}
	
}
