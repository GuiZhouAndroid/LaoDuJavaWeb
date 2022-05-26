package com.bjpowernode.javaweb.servlet;

import com.bjpowernode.javaweb.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 保存学生信息到数据库
        request.setCharacterEncoding("UTF-8");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into t_student(no,name) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, no);
            ps.setString(2, name);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
        // 保存成功之后跳转到成功页面
        if (count == 1) {
            // 转发
            //request.getRequestDispatcher("/success.html").forward(request, response);

            // 重定向
            response.sendRedirect(request.getContextPath() + "/success.html");
        }else{

        }
        
    }
}
