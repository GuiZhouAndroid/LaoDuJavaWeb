package com.dhrj.zs.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * created by on 2022/4/29
 * 描述：JDBC工具类
 *
 * @author ZSAndroid
 * @create 2022-04-29-17:20
 */
public class JDBCUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    private static final String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String username = bundle.getString("username");
    private static String password = bundle.getString("password");

    static {
        try {
            //注册驱动，类加载时执行一次
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
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
