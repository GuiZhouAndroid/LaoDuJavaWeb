package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "hello",
        urlPatterns = {"/hello1", "/hello2", "/hello3"},
        //loadOnStartup = 1,
 initParams = {@WebInitParam(name="username", value="root"), @WebInitParam(name="password", value="123")})
public class HelloServlet extends HttpServlet {

    // 无参数构造方法

    public HelloServlet() {
        System.out.println("无参数构造方法执行，HelloServlet加载完成");
    }


    /*@WebServlet
    private String name;*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取Servlet Name
        String servletName = getServletName();
        out.print("servlet name = " + servletName + "<br>");

        // 获取servlet path
        String servletPath = request.getServletPath();
        out.print("servlet path = " + servletPath + "<br>");

        // 获取初始化参数
        Enumeration<String> names = getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }
    }
}
