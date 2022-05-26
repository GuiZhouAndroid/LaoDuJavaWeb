package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        // 设置响应的内容类型
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        // 连接数据库（JDBC）
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/mybatisDemo";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            // 获取预编译的数据库操作对象
            String sql = "select id i,name n,email e, age a from student";
            ps = conn.prepareStatement(sql);
            // 执行SQL
            resultSet = ps.executeQuery();
            // 处理结果集
            while(resultSet.next()){
                int id = resultSet.getInt("i");
                String name = resultSet.getString("n");
                String email = resultSet.getString("e");
                int age = resultSet.getInt("a");
                printWriter.println("id= " + id + ",姓名=" + name + "，邮箱=" + email + "，年龄=" + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
