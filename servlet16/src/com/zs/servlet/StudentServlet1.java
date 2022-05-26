package com.zs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * created by on 2022/4/28
 * 描述：
 *
 * @author ZSAndroid
 * @create 2022-04-28-11:41
 */
public class StudentServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");//设置服务端文本编码格式响应发送到浏览器客户端
        PrintWriter printWriter = resp.getWriter();//服务端向浏览器响应发送字符输出流数据
        printWriter.println("<h1>收到菲利克斯分类算法</h2>");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter printWriter = resp.getWriter();//服务端向浏览器响应发送字符输出流数据
//        printWriter.println(req.getParameter("username"));
//        printWriter.println(req.getParameter("password"));
//
//        Map<String, String[]> stringsMap =  req.getParameterMap();
//
//        String[] strings = stringsMap.get("username");
//        for (String s :strings) {
//            System.out.println(s);
//        }
//        String[] strings2 = stringsMap.get("password");
//        for (String s :strings2) {
//            System.out.println(s);
//        }
//
//        String[] strings3 = req.getParameterValues("username");
//        for (String s :strings3) {
//            System.out.println(s);
//        }
//    }
}
