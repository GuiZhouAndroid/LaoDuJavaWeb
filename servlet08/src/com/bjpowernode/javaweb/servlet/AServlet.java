package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取系统当前时间
        Date nowTime = new Date();

        // 将系统当前时间绑定到请求域当中
        request.setAttribute("sysTime", nowTime);

        // 取出来
        //Object sysTime = request.getAttribute("sysTime");

        // 输出到控制台
        //System.out.println(sysTime);

        // 这样做可以吗？
        // 在AServlet当中new一个BServlet对象，然后调用BServlet对象的doGet方法，把request对象传过去。
        // 这个代码虽然可以实现功能，但是Servlet对象不能自己由程序员来new。自己new的Servlet对象生命周期不受Tomcat服务器的管理。
        /*BServlet bServlet = new BServlet();
        bServlet.doGet(request, response);*/

        // 使用Servlet当中的转发机制。
        // 执行了AServlet之后，跳转到BServlet。（这个资源跳转可以使用转发机制来完成。）
        // 怎么转发？代码怎么写？
        // 第一步：获取请求转发器对象
        // 相当于把"/b"这个路径包装到请求转发器当中，实际上是把下一个跳转的资源的路径告知给Tomcat服务器了。
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/b");

        // 第二步：调用请求转发器RequestDispatcher的forward方法。进行转发。
        // 转发的时候：这两个参数很重要。request和response都是要传递给下一个资源的。
        //dispatcher.forward(request, response);

        // 一行代码搞定转发。
        //request.getRequestDispatcher("/b").forward(request, response);

        // 转发到一个Servlet，也可以转发到一个HTML，只要是WEB容器当中的合法资源即可。
        request.getRequestDispatcher("/test.html").forward(request, response);

    }
}
