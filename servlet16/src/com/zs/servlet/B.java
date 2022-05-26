package com.zs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * created by on 2022/4/29
 * 描述：
 *
 * @author ZSAndroid
 * @create 2022-04-29-15:20
 */
public class B extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("time"));
        req.getRequestDispatcher("/login.html").forward(req,resp);
    }
}
