package com.wzx.service;

import com.wzx.pojo.FileName;
import com.wzx.pojo.User;

import java.util.List;

public interface FileService {
    public List<FileName> getFileNames(User user);
    public int saveFile(int id,String filename);
    public int deleteFile(int id,String filename);
}
