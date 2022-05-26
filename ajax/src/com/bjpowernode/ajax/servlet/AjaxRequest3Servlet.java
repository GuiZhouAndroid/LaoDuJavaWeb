package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: 代码
 * @ClassName: AjaxRequest3Servlet
 * @version: 1.0
 * @description: 发送AJAX POST请求
 * @author: bjpowernode
 * @create: 2022-05-13 15:39
 **/
@WebServlet("/ajaxrequest3")
public class AjaxRequest3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.print("<font color='red'>用户名已存在！！！</font>");

        // 获取提交数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.print("用户名是：" + username + "，密码是：" + password);
    }
}
