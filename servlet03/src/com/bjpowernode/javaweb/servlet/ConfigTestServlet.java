package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletConfig
 *   1. ServletConfig是什么？
 *      jakarta.servlet.ServletConfig
 *      显然ServletConfig是Servlet规范中的一员。
 *      ServletConfig是一个接口。（jakarta.servlet.Servlet是一个接口。）
 *   2. 谁去实现了这个接口呢？ WEB服务器实现了
 *      public class org.apache.catalina.core.StandardWrapperFacade implements ServletConfig {}
 *      结论：Tomcat服务器实现了ServletConfig接口。
 *      思考：如果把Tomcat服务器换成jetty服务器，输出ServletConfig对象的时候，还是这个结果吗？
 *          不一定一样，包名类名可能和Tomcat不一样。但是他们都实现了ServletConfig这个规范。
 *   3. 一个Servlet对象中有一个ServletConfig对象。（Servlet和ServletConfig对象是一对一。）
 *      100个Servlet，就应该有100个ServletConfig对象。
 *   4. ServletConfig对象是谁创建的？在什么时候创建的？
 *      Tomcat服务器（WEB服务器）创建了ServletConfig对象。
 *      在创建Servlet对象的时候，同时创建ServletConfig对象。
 *   5. ServletConfig接口到底是干啥的？有什么用呢？
 *      Config是哪个单词的缩写？
 *          Configuration
 *      ServletConfig对象被翻译为：Servlet对象的配置信息对象。
 *      一个Servlet对象就有一个配置信息对象。
 *      两个Servlet对象就有两个配置信息对象。
 *
 *   6. ServletConfig对象中到底包装了什么信息呢？
 *      <servlet>
 *         <servlet-name>configTest</servlet-name>
 *         <servlet-class>com.bjpowernode.javaweb.servlet.ConfigTestServlet</servlet-class>
 *     </servlet>
 *     ServletConfig对象中包装的信息是：
 *          web.xml文件中<servlet></servlet>标签的配置信息。
 *
 *     Tomcat小猫咪解析web.xml文件，将web.xml文件中<servlet></servlet>标签中的配置信息自动包装到ServletConfig对象中。
 *
 *   7. ServletConfig接口中有哪些方法？
 *      <servlet>
 *         <servlet-name>configTest</servlet-name>
 *         <servlet-class>com.bjpowernode.javaweb.servlet.ConfigTestServlet</servlet-class>
 *         <!--这里是可以配置一个Servlet对象的初始化信息的。-->
 *         <init-param>
 *             <param-name>driver</param-name>
 *             <param-value>com.mysql.cj.jdbc.Driver</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>url</param-name>
 *             <param-value>jdbc:mysql://localhost:3306/bjpowernode</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>user</param-name>
 *             <param-value>root</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>password</param-name>
 *             <param-value>root1234</param-value>
 *         </init-param>
 *     </servlet>
 *     以上<servlet></servlet>标签中的<init-param></init-param>是初始化参数。这个初始化参数信息会自动被小猫咪封装到ServletConfig对象当中。
 *  8. ServletConfig接口中有4个方法：
 *      第1个方法：
 *          public String getInitParameter(String name);
 *      第2个方法：
 *          public Enumeration<String> getInitParameterNames();
 *      第3个方法：
 *          public ServletContext getServletContext();
 *      第4个方法：
 *          public String getServletName();
 *
 *      以上的4个方法，在自己编写的Servlet类当中也可以使用this去调用。（这个Servlet继承了GenericServlet）
 */
public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        // 输出该对象
        // org.apache.catalina.core.StandardWrapperFacade@aea0d43
        out.print("ServletConfig对象是：" + config.toString());
        out.print("<br>");

        // 获取<servlet-name></servlet-name>
        String servletName = config.getServletName();
        out.print("<servlet-name>"+servletName+"</servlet-name>");
        out.print("<br>");

        // 通过ServletConfig对象的两个方法，可以获取到web.xml文件中的初始化参数配置信息。
        // java.util.Enumeration<java.lang.String>	getInitParameterNames() 获取所有的初始化参数的name
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        // 遍历集合
        while(initParameterNames.hasMoreElements()) { // 是否有更多元素
            String parameterName = initParameterNames.nextElement(); // 取元素
            String parameterVal = config.getInitParameter(parameterName); // 通过name获取value
            out.print(parameterName + "=" + parameterVal);
            out.print("<br>");
        }
        // java.lang.String	getInitParameter(java.lang.String name) 通过初始化参数的name获取value
        /*String driver = config.getInitParameter("driver");
        out.print(driver);*/

        // 实际上获取一个Servlet对象的初始化参数，可以不用获取ServletConfig对象。直接通过this也可以。
        Enumeration<String> names = this.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            // 打印到后台
            System.out.println(name + "=" + value);
        }

        // 怎么获取ServletContext对象呢？
        // 第一种方式：通过ServletConfig对象获取ServletContext对象。
        ServletContext application = config.getServletContext();
        // 输出
        out.print("<br>" + application); //org.apache.catalina.core.ApplicationContextFacade@19187bbb

        // 第二种方式：通过this也可以获取ServletContext对象。
        ServletContext application2 = this.getServletContext();
        out.print("<br>" + application2); //org.apache.catalina.core.ApplicationContextFacade@19187bbb
    }
}

