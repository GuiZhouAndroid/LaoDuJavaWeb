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
 * @ClassName: AjaxRequest2Servlet
 * @version: 1.0
 * @description:
 * @author: bjpowernode
 * @create: 2022-05-13 10:46
 **/

@WebServlet("/ajaxrequest2")
public class AjaxRequest2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应的内容类型以及字符集
        response.setContentType("text/html;charset=UTF-8");
        // 获取响应流
        PrintWriter out = response.getWriter();
        // 响应
        //out.print("<font color='red'>用户名已存在！！！</font>");

        // 获取ajax get请求提交的数据
        String usercode = request.getParameter("usercode");
        String username = request.getParameter("username");

        out.print("usercode=" + usercode + ", username=" + username);

    }
}
