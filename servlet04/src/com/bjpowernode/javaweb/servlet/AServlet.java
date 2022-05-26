package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletContext
 * 1. ServletContext是什么？
 *  ServletContext是接口，是Servlet规范中的一员。
 * 2. ServletContext是谁实现的？
 *  Tomcat服务器（WEB服务器）实现了ServletContext接口。
 *  public class org.apache.catalina.core.ApplicationContextFacade implements ServletContext {}
 * 3. ServletContext对象是谁创建的？在什么时候创建的？
 *  ServletContext对象在WEB服务器启动的时候创建。
 *  ServletContext对象是WEB服务器创建的。
 *  对于一个webapp来说，ServletContext对象只有一个。
 *  ServletContext对象在服务器关闭的时候销毁。
 * 4. ServletContext怎么理解？
 *  context是什么意思？
 *      Servlet对象的环境对象。（Servlet对象的上下文对象。）
 *  ServletContext对象其实对应的就是整个web.xml文件。
 *  50个学生，每个学生都是一个Servlet，这50个学生都在同一个教室当中。那么这个教室就相当于ServletContext对象。
 *  放在ServletContext对象当中的数据，所有Servlet一定是共享的。
 *  比如：一个教室中的空调是所有学生共享的，一个教室中的语文老师是所有学生共享的。
 *  Tomcat是一个容器，一个容器当中可以放多个webapp，一个webapp对应一个ServletContext对象。
 */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取ServletContext对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象是：" + application + "<br>");

        // 获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        // 获取context path （获取应用上下文的根）
        String contextPath = application.getContextPath();
        out.print(contextPath + "<br>");

        // 获取文件的绝对路径
        // 后面的这个路径，加了一个“/”，这个“/”代表的是web的根
        //String realPath = application.getRealPath("/index.html"); // 可以
        // 你不加“/”，默认也是从根下开始找。
        //String realPath = application.getRealPath("index.html"); // 不加“/”也可以
        //out.print(realPath + "<br>");

        // C:\Users\Administrator\IdeaProjects\javaweb\out\artifacts\servlet04_war_exploded\common\common.html
        String realPath = application.getRealPath("/common/common.html");
        out.print(realPath + "<br>");

        // 准备数据
        User user = new User("jack", "123");
        // 向ServletContext应用域当中存储数据
        application.setAttribute("userObj", user);
        // 取出来
        //Object userObj = application.getAttribute("userObj");
        // 输出到浏览器
        //out.print(userObj + "<br>");

    }
}
