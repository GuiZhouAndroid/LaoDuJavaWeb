package com.bjpowernode.ajax.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.ajax.beans.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 代码
 * @ClassName: ListAreaServlet
 * @version: 1.0
 * @description: 动态获取对应的区域
 * @author: bjpowernode
 * @create: 2022-05-15 21:57
 **/
@WebServlet("/listArea")
public class ListAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pcode = request.getParameter("pcode");

        // 连接数据库，获取所有的对应区域。最终响应一个JSON格式的字符串给WEB前端。
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Area> areaList = new ArrayList<>();
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/bjpowernode?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            // 获取预编译数据库操作对象
            String sql = "";
            if(pcode == null){
                sql = "select code,name from t_area where pcode is null";
                ps = conn.prepareStatement(sql);
            }else{
                sql = "select code,name from t_area where pcode = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, pcode);
            }

            // 执行SQL
            rs = ps.executeQuery();
            // 处理结果集
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area a = new Area(code, name);
                areaList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
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

        response.setContentType("text/html;charset=UTF-8");
        // 使用fastjson将java对象转换成json字符串。
        String json = JSON.toJSONString(areaList);
        // 响应JSON。
        response.getWriter().print(json);
    }
}
