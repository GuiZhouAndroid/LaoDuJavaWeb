package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/abc")
//@WebFilter("/a.do")
//@WebFilter({"/a.do", "/b.do"})

/*以下这个路径属于模糊匹配中的扩展匹配。以星号开始，注意这种路径不要以/开始。*/
@WebFilter("*.do")

/*属于前缀匹配。要以/开始。*/
//@WebFilter("/dept/*")

// 匹配所有的路径。
//@WebFilter("/*")
public class Filter1 implements Filter {

    /*public Filter1(){
        System.out.println("无参数构造方法执行");
    }*/

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行。");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 在请求的时候添加过滤规则。
        System.out.println("Filter1 doFilter方法开始执行。");
        // 执行下一个过滤器，如果下一个不是过滤器了，则执行目标程序Servlet。
        // 向下走。没有它是不行滴。
        chain.doFilter(request, response);

        // 在响应的时候添加过滤规则。
        System.out.println("Filter1 doFilter方法执行结束。");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行");
    }
}
