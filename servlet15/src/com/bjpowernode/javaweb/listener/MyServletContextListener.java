package com.bjpowernode.javaweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// ServletContextListener监听器主要监听的是：ServletContext对象的状态。
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * 监听器中的方法不需要程序员手动调用。是发生某个特殊事件之后被服务器调用。
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) { // 服务器启动时间点，想在这个时候执行一段代码，写就行了。
        // 现在这个特殊的时刻写代码，你写就是了。它会被服务器自动调用。
        // 这个方法是在ServletContext对象被创建的时候调用。
        System.out.println("ServletContext对象创建了。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { // 服务器关闭时间点。
        // 现在这个特殊的时刻写代码，你写就是了。它会被服务器自动调用。
        // 这个方法是在ServletContext对象被销毁的时候调用。
        System.out.println("ServletContext对象被销毁了。");
    }
}
