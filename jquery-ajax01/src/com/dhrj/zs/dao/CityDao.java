package com.dhrj.zs.dao;

import com.dhrj.zs.entity.City;
import com.dhrj.zs.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by on 2022/6/2
 * 描述：查询市信息数据层
 *
 * @author ZSAndroid
 * @create 2022-06-02-20:09
 */
public class CityDao {
    /**
     * 通过省份ID查询对应的全部市信息
     */
    public List<City> queryAllCityById(Integer provinceId) {
        List<City> cityList = new ArrayList<City>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select  id, name from city where provinceid = ?");
            preparedStatement.setInt(1, provinceId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cityList.add(new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cityList;
    }
}
