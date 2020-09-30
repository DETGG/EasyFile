package com.wzx.dao;

import com.wzx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public abstract class BaseDao {

    //use the DBUtils to Operate the dataBase
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * to run:Insert\Update\Delete sql
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object ... args){
        Connection connection = JDBCUtils.getConnect();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return -1;
    }

    /**
     * sql for searching javaBean
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(String sql,Class<T> type,Object...args){
        Connection connection = JDBCUtils.getConnect();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     * sql for searching some javaBean
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(String sql,Class<T> type,Object...args){
        Connection connection = JDBCUtils.getConnect();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     * sql for searching one line
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object...args){
        Connection connection = JDBCUtils.getConnect();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return null;
    }
}
