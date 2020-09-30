package com.wzx.service.impl;

import com.wzx.dao.FileDao;
import com.wzx.dao.impl.FileDaoImpl;
import com.wzx.pojo.FileName;
import com.wzx.pojo.User;
import com.wzx.service.FileService;

import java.util.List;

public class FileServiceImpl implements FileService {
    FileDao fileDao = new FileDaoImpl();

    @Override
    public List<FileName> getFileNames(User user) {
        return fileDao.QueryFilesByID(user.getId());
    }

    @Override
    public int saveFile(int id, String filename) {
        return fileDao.SaveFile(id,filename);
    }

    @Override
    public int deleteFile(int id, String filename) {
        return fileDao.deleteFile(id, filename);
    }
}
