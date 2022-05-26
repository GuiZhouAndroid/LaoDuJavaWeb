package com.bjpowernode.ajax.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.ajax.beans.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 代码
 * @ClassName: AjaxRequest5Servlet
 * @version: 1.0
 * @description: 发送AJAX请求动态展示学员列表
 * @author: bjpowernode
 * @create: 2022-05-14 12:08
 **/
@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 连接数据库，查询学员信息，拼接HTML代码，响应HTML代码到浏览器（这里就不再连接数据库了，写死了。）
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /*// 连接数据库，拼接HTML代码
        StringBuilder html = new StringBuilder();

        // 目前存在的缺点：在后端的java代码中又开始拼接HTML代码了。显然这是在后端java中写前端的HTML代码。不好维护。
        // 能不能直接将数据返回，给WEB前端数据就行了。让WEB前端能够拿到数据就行，然后页面展示的功能交给WEB前端来处理。
        // 我们后端的java代码能不能只返回数据？？？？可以。（返回数据可以采用JSON的格式，也可以采用XML的格式）
        html.append("<tr>");
        html.append("<td>1</td>");
        html.append("<td>王五</td>");
        html.append("<td>20</td>");
        html.append("<td>北京大兴区</td>");
        html.append("</tr>");
        html.append("<tr>");
        html.append("<td>2</td>");
        html.append("<td>李四</td>");
        html.append("<td>22</td>");
        html.append("<td>北京海淀区</td>");
        html.append("</tr>");

        out.print(html);*/

        // 将以上程序拼接HTML，换成拼接JSON格式的字符串。
        //String jsonStr = "[{\"name\":\"王五\",\"age\":20,\"addr\":\"北京大兴区\"}, {\"name\":\"李四\",\"age\":22,\"addr\":\"北京海淀区\"}]";

        // 准备StringBuilder对象，拼接JSON
        StringBuilder json = new StringBuilder();
        String jsonStr = "";

        // 连接数据库，查询所有的学生，拼接json字符串
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisDemo?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "root");
            // 3.获取预编译的数据库操作对象
            String sql = "select name, age, addr from t_student";
            ps = conn.prepareStatement(sql);
            // 4.执行SQL语句
            rs = ps.executeQuery();
            // 5.处理结果集
            /*json.append("[");
            while (rs.next()) {
                // 获取每个学生的信息
                String name = rs.getString("name");
                String age = rs.getString("age");
                String addr = rs.getString("addr");
                // 拼接json格式的字符串
                // {"name":"   王五    ","age":    20      ,"addr":"      北京大兴区     "},
                json.append("{\"name\":\"");
                json.append(name);
                json.append("\",\"age\":");
                json.append(age);
                json.append(",\"addr\":\"");
                json.append(addr);
                json.append("\"},");
            }
            jsonStr = json.substring(0, json.length() - 1) + "]";*/


            List<Student> studentList = new ArrayList<>();
            while (rs.next()) {
                // 取出数据
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String addr = rs.getString("addr");
                // 将以上数据封装成Student对象
                Student s = new Student(name, age, addr);
                // 将Student对象放到List集合
                studentList.add(s);
            }

            // 将List集合转换成json字符串
            jsonStr = JSON.toJSONString(studentList);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
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

        // 响应JSON格式的字符串给前端。
        out.print(jsonStr);
    }
}
