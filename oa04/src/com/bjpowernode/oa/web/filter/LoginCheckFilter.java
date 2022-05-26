package com.bjpowernode.oa.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        /**
         * 什么情况下不能拦截？
         *      目前写的路径是：/* 表示所有的请求均拦截。
         *
         *      用户访问 index.jsp的时候不能拦截
         *      用户已经登录了，这个需要放行，不能拦截。
         *      用户要去登录，这个也不能拦截。
         *      WelcomeServlet也不能拦截。
         */

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 获取请求路径
        String servletPath = request.getServletPath();

        HttpSession session = request.getSession(false);
        /*if("/index.jsp".equals(servletPath) || "/welcome".equals(servletPath) ||
                "/user/login".equals(servletPath) || "/user/exit".equals(servletPath)
                || (session != null && session.getAttribute("username") != null)){*/

        if("/index.jsp".equals(servletPath) || "/welcome".equals(servletPath) ||
                "/user/login".equals(servletPath) || "/user/exit".equals(servletPath)
                || (session != null && session.getAttribute("user") != null)){

            // 继续往下走
            chain.doFilter(request, response);
        }else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
