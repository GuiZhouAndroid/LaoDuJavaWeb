package com.zs.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * created by on 2022/5/6
 * 描述：
 *
 * @author ZSAndroid
 * @create 2022-05-06-13:40
 */
@WebFilter({"/a","/b"})
public class FilterOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter【开始】");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter【结束】");
    }

    @Override
    public void destroy() {
        System.out.println("destroy销毁");
    }
}
