package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 获取ServletConfig对象
        ServletConfig config = this.getServletConfig();

        // 输出
        // org.apache.catalina.core.StandardWrapperFacade@287af686
        out.print("ServletConfig对象：" + config);

        String value = config.getInitParameter("key");
        out.print("<br>" + value);
    }
}
