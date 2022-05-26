package com.zs.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * created by on 2022/4/28
 * 描述：
 *
 * @author ZSAndroid
 * @create 2022-04-28-11:41
 */
public class StudentServlet extends HttpServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=UTF-8");//设置服务端文本编码格式响应发送到浏览器客户端
        PrintWriter printWriter = servletResponse.getWriter();//服务端向浏览器响应发送字符输出流数据
        //获取web.xml中Servlet配置的初始化参数--->迭代器遍历，共享范围仅限本Servlet类使用
        Iterator<String> enumeration = getInitParameterNames().asIterator();
        while (enumeration.hasNext()){
            System.out.println(enumeration.next());
        }

        //获取Servlet全局上下文共享的初始化参数，每一个Servlet实例对象的ServletConfig都能共享
        Enumeration<String> stringEnumeration = getServletContext().getInitParameterNames();
        while (stringEnumeration.hasMoreElements()){
            System.out.println(stringEnumeration.nextElement());
        }
        //获取web应用根路径
        System.out.println(getServletContext().getContextPath());
        //获取指定文件的绝对路径
        System.out.println(getServletContext().getRealPath("/login.html"));
        //记录日志，输出到Tomcat根目录下的logs目录中
        getServletContext().log("我是日志呀，输出到Tomcat根目录下的logs目录中");
        //ServletContext存数据
        getServletContext().setAttribute("key","valueasdsadada");
        //ServletContext取数据
        System.out.println(getServletContext().getAttribute("key"));
        //开始JDBC连接数据库
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisDemo", "root", "root");
            //获取数据库操作对象
            preparedStatement = connection.prepareStatement("select id i,name n,email e, age a from student");
            //执行SQL
            resultSet = preparedStatement.executeQuery();
            //处理返回结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("i");
                String name = resultSet.getString("n");
                String email = resultSet.getString("e");
                int age = resultSet.getInt("a");
                printWriter.println("id= " + id + ",姓名=" + name + "，邮箱=" + email + "，年龄=" + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
