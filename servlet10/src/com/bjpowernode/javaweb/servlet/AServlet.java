package com.bjpowernode.javaweb.servlet;

import com.bjpowernode.javaweb.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 创建一个用户对象
        User user = new User();
        user.setId("111111");
        user.setName("杰克");

        // 将用户对象存储到请求域当中
        request.setAttribute("userObj", user);

        // 转发
        //request.getRequestDispatcher("/b").forward(request, response);

        // 重定向（重新定方向）
        // 重定向时的路径当中需要以项目名开始，或者说需要添加项目名。
        // response对象将这个路径："/servlet10/b"响应给浏览器了。
        // 浏览器又自发的向服务器发送了一次全新的请求：http://localhost:8080/servlet10/b
        // 所以浏览器一共发送了两次请求：
        // 第一次请求：http://localhost:8080/servlet10/a
        // 第二次请求：http://localhost:8080/servlet10/b
        // 最终浏览器地址栏上显示的地址当然是最后那一次请求的地址。所以重定向会导致浏览器地址栏上的地址发生改变。
        response.sendRedirect(request.getContextPath() + "/b");
    }
}
