package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * 编写一个标准通用的Servlet，起名：GenericServlet
 * 以后所有的Servlet类都不要直接实现Servlet接口了。
 * 以后所有的Servlet类都要继承GenericServlet类。
 * GenericServlet 就是一个适配器。
 */
public abstract class GenericServlet implements Servlet {

    // 成员变量
    private ServletConfig config;

    /**
     * init方法中的ServletConfig对象是小猫咪创建好的。
     * 这个ServletConfig对象目前在init方法的参数上，属于局部变量。
     * 那么ServletConfig对象肯定以后要在service方法中使用，怎么才能保证ServletConfig对象在service方法中能够使用呢？
     */
    @Override
    public final void init(ServletConfig config) throws ServletException {
        //System.out.println("servletConfig对象，小猫咪创建好的：" + config);
        this.config = config;
        // 调用init()方法
        this.init();
    }

    /**
     * 这个init方法是供子类重写的。
     */
    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 抽象方法，这个方法最常用。所以要求子类必须实现service方法。
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
