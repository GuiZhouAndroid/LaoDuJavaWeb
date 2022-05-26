package com.bjpowernode.javaweb.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    // request对象销毁时间点
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象销毁了");
    }

    // request对象创建时间点
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象初始化了");
    }
}
