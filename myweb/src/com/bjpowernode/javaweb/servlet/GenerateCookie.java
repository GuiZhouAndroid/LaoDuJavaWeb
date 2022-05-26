package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 创建cookie对象
        Cookie cookie = new Cookie("username", "admin");
        // 设置cookie的有效时间
        //cookie.setMaxAge(60 * 60);
        //cookie.setMaxAge(0);
        //cookie.setMaxAge(-1);
        // 设置cookie的关联路径
        cookie.setPath(request.getContextPath() + "/test/abc");
        // 设置cookie关联的域名
        cookie.setDomain("test2.com.cn");
        // 响应cookie到客户端
        response.addCookie(cookie);

    }
}
