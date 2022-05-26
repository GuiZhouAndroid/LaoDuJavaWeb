package com.dhrj.zs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * created by on 2022/4/29
 * 描述：
 *
 * @author ZSAndroid
 * @create 2022-04-29-17:20
 */
@WebServlet(urlPatterns = {"/api/user"},initParams = @WebInitParam(name = "qwe",value = "Qwe"))
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie= new Cookie("ZS","zhangsong");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
//
//        HttpSession session = req.getSession();
//        System.out.println(session.toString());

    }
}
