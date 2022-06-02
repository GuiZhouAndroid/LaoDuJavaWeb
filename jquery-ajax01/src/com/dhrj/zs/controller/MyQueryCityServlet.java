package com.dhrj.zs.controller;

import com.alibaba.fastjson.JSON;
import com.dhrj.zs.dao.CityDao;
import com.dhrj.zs.dao.ProvinceDao;
import com.dhrj.zs.entity.City;
import com.dhrj.zs.entity.Province;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * created by on 2022/6/2
 * 描述：查询市信息控制器
 *
 * @author ZSAndroid
 * @create 2022-06-02-20:07
 */
@WebServlet("/my/city")
public class MyQueryCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据库
        List<City> allProvinces = new CityDao().queryAllCityById(Integer.valueOf(request.getParameter("pro_id")));
        //响应到AJAX的success函数的实参为json字符串
        response.setContentType("application/json;charset=UTF-8");
        //使用fastjson将java对象转换成json字符串。
        String json = JSON.toJSONString(allProvinces);
        // 响应请求执行返回JSON
        response.getWriter().print(json);
    }
}
