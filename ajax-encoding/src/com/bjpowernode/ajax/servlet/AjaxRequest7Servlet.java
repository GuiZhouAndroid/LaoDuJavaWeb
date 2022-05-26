package com.bjpowernode.ajax.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: 代码
 * @ClassName: AjaxRequest7Servlet
 * @version: 1.0
 * @description: 测试ajax乱码问题
 * @author: bjpowernode
 * @create: 2022-05-15 12:25
 **/
@WebServlet("/ajaxrequest7")
public class AjaxRequest7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 接收的中文会不会乱码
        String username = request.getParameter("username");
        System.out.println(username);
        // 响应中文会有乱码吗？
        response.setContentType("text/html;charset=UTF-8"); // tomcat9以及之前的版本，这行代码是必须要加的。
        PrintWriter out = response.getWriter();
        out.print(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 接收的中文会不会乱码
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);
        // 响应中文会有乱码吗？
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(username);
    }
}
