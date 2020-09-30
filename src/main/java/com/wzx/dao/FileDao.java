package com.wzx.dao;

import com.wzx.pojo.FileName;

import java.util.List;

public interface FileDao {
    public List<FileName> QueryFilesByID(int id);
    public int SaveFile(int id,String filename);
    public int deleteFile(int id,String filename);
}
