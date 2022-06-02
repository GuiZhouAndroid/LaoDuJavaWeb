package com.dhrj.zs.dao;

import com.dhrj.zs.entity.Province;
import com.dhrj.zs.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by on 2022/6/2
 * 描述：查询省信息数据层
 *
 * @author ZSAndroid
 * @create 2022-06-02-20:08
 */
public class ProvinceDao {
    /**
     * 查询全部省份信息
     */
    public List<Province> queryAllProvinces() {
        List<Province> provinceList = new ArrayList<Province>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id,name,jiancheng,shenghui from province order by id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                provinceList.add(new Province(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("jiancheng"),
                        resultSet.getString("shenghui"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return provinceList;
    }
}
