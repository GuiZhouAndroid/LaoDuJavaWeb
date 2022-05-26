package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        // 响应一些内容到浏览器上。
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // out.println() 是输出信息到浏览器，最终源代码中换行。（不是网页上有换行效果，网页上有换行效果必须使用<br>）
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>from get servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>from get servlet</h1>");
        out.println("    </body>");
        out.println("</html>");
    }
}
