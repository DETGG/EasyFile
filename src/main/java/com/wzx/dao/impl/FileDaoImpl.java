package com.wzx.dao.impl;

import com.wzx.dao.BaseDao;
import com.wzx.dao.FileDao;
import com.wzx.pojo.FileName;

import java.util.List;

public class FileDaoImpl extends BaseDao implements FileDao {
    @Override
    public List<FileName> QueryFilesByID(int id) {
        String sql = "select filename from file where id = ?";
        return queryForList(sql,FileName.class,id);
    }

    @Override
    public int SaveFile(int id, String filename) {
        String sql = "insert into file(id,filename) values(?,?)";
        return update(sql,id,filename);
    }

    @Override
    public int deleteFile(int id, String filename) {
        String sql = "delete from file where id = ? and filename =?";
        return update(sql,id,filename);
    }
}
