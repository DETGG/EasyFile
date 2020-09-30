package com.wzx.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;

    static {
        Properties properties;
        try {
            properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * get a connection from pool
     * @return
     */
    public static Connection getConnect() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * put connection back to connection pool
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * get the pool
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * check login
     * @param id
     * @param password
     * @return
     */
    public static boolean Login(int id,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean success = false;
        try {
            connection = JDBCUtils.getConnect();
            String sql = "select * from user where id = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            success = resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return success;
    }
}
