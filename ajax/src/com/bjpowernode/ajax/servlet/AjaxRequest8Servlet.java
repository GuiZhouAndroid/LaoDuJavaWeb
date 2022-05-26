package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 代码
 * @ClassName: AjaxRequest8Servlet
 * @version: 1.0
 * @description: 测试ajax同步和异步
 * @author: bjpowernode
 * @create: 2022-05-15 13:06
 **/
@WebServlet("/ajaxrequest8")
public class AjaxRequest8Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("ajax请求1");
    }
}
