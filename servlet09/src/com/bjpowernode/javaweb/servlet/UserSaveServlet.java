package com.bjpowernode.javaweb.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserSaveServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realname = request.getParameter("realname");
        System.out.println(realname);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置请求体的字符集
        request.setCharacterEncoding("UTF-8");

        // 获取用户提交的用户名
        String username = request.getParameter("username");

        // 输出username
        System.out.println(username);


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("大家好，我是一名Java软件工程师");

    }
}
