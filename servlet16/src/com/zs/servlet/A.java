package com.zs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

/**
 * created by on 2022/4/29
 * 描述：
 *
 * @author ZSAndroid
 * @create 2022-04-29-15:20
 */
public class A extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date data = new Date();
        req.setAttribute("time", data);
        //Servlet转发机制 共享两个请求域临时数据

        //获取请求转发器,Tomcat服务器当中的合法资源（html、Servlet），都是可以转发的。
        req.getRequestDispatcher("/b").forward(req, resp);
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getRequestURL());
        System.out.println(req.getRequestURI());
        //获取web应用的根路径
        System.out.println(req.getContextPath());
        System.out.println(req.getMethod());
        System.out.println(req.getServletPath());

        //记录日志，输出到Tomcat根目录下的logs目录中
        getServletContext().log("我是日志呀，输出到Tomcat根目录下的logs目录中");
    }
}
