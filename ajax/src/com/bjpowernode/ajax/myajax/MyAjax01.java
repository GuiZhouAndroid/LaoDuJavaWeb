package com.bjpowernode.ajax.myajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by on 2022/5/24
 * 描述：我的第一个AJAX请求
 *
 * @author ZSAndroid
 * @create 2022-05-24-15:31
 */
@WebServlet("/MyAjax01")
public class MyAjax01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter print = response.getWriter();
        print.print("<font color = red>我是第一个AJAX的Servlet请求</font>");
    }
}
