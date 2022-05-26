package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sendCookie")
public class ReceiveCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 通过java程序怎么接收到浏览器发送过来的cookie呢？
        // 当然通过request对象了。（返回值是一个数组，因为浏览器可能会提交多个cookie给服务器。）
        // 注意细节：这个方法可能会返回null。如果浏览器没有提交cookie，这个方法返回值是null，并不是返回一个长度为0的数组。
        Cookie[] cookies = request.getCookies();

        // 如果不是null，表示一定有cookie
        if (cookies != null) {
            // 遍历数组
            for (Cookie cookie : cookies) {
                // 获取cookie的name和value
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + "=" + value);
            }
        }

    }
}
