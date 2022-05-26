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

        // 创建Cookie对象
        Cookie cookie = new Cookie("productid", "12345645623145612");
        Cookie cookie2 = new Cookie("username", "zhangsan");

        // 设置cookie在一小时之后失效。（保存在硬盘文件当中）
        //cookie.setMaxAge(60 * 60);
        // 设置cookie的有效期为0，表示该cookie被删除。主要应用在：使用这种方式删除浏览器上的同名cookie。
        //cookie.setMaxAge(0);
        // 设置cookie的有效期 < 0，表示该cookie不会被存储。（表示不会被存储到硬盘文件中。会放在浏览器运行内存当中。）
        cookie.setMaxAge(-1); // 和不调用sexMaxAge是同一个效果。
        cookie2.setMaxAge(-1);

        // 默认情况下，没有设置path的时候，cookie关联的路径是什么？
        //cookie.setPath("/servlet13");
        cookie.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());

        // 将cookie响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
