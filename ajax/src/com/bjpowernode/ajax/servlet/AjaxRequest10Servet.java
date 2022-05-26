package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 代码
 * @ClassName: AjaxRequest10Servet
 * @version: 1.0
 * @description: 将AJAX请求封装到jQuery当中
 * @author: bjpowernode
 * @create: 2022-05-15 19:10
 **/
@WebServlet("/ajaxrequest10")
public class AjaxRequest10Servet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        //{"uname" : "zhangsan"}
        response.getWriter().print("{\"uname\" : \""+username+"\"}");
    }
}
