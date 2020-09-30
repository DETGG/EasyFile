package com.wzx.web;

import com.wzx.pojo.FileName;
import com.wzx.pojo.User;
import com.wzx.service.FileService;
import com.wzx.service.impl.FileServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.List;

public class FileServlet extends HttpServlet {

    FileService fileService = new FileServiceImpl();

    protected void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //down load path : is base on the webapp package

        String path = request.getServletContext().getRealPath("");
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
//                        System.out.println(basePath);
//                        System.out.println(path);

        String downloadFileName = request.getParameter("download");
//        downloadFileName = URLDecoder.decode(downloadFileName,"UTF-8"); //no use

        User user = (User) request.getSession().getAttribute("user");

        Integer id = user.getId();

        System.out.println("user " + id + " download file:" + downloadFileName);

        //set response inf:file type and how to handle it
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("files/" + id + "/" + downloadFileName);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
        //input then output
        InputStream resourceAsStream = servletContext.getResourceAsStream("files/" + id + "/" + downloadFileName);

        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
    }

    protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //build the factory class
        FileItemFactory fileItemFactory = new DiskFileItemFactory();

        System.out.println("upload");
        //if is some parts,it could be file
        if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //normal:not file
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString("UTF-8"));
                    } else {
                        User user = (User) request.getSession().getAttribute("user");
                        Integer id = user.getId();
                        String filename = fileItem.getName();

                        //save file to the storage
                        //upload file is depend on the absolute path including pan:\project\..\FTPServer\
                        String path = request.getServletContext().getRealPath("");
                        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                        File file = new File(path + "/files/" + id + "/");
                        file.mkdirs();
                        File file1 = new File(file + "/" + filename);
                        if (!file1.exists()) {
                            fileItem.write(file1);

                            //save filename and id to mysql
                            fileService.saveFile(id, filename);

                            //send files belong to user
                            List<FileName> fileNames = fileService.getFileNames(user);
                            request.getSession().setAttribute("files", fileNames);

                            //test
                            System.out.println("user " + user.getId() + " upload file:" + filename);
                        }else {
                            //filename exist
                        }
                        response.sendRedirect("pages/main.jsp");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();
        String filename = request.getParameter("delete");

        //delete file is depend on the absolute path including pan:\project\..\FTPServer\
        String path = request.getServletContext().getRealPath("");
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

        File file = new File(path + "/files/" + id + "/" + filename);
        if (file.exists()) {
            //delete file from the storage
            file.delete();

            //save filename and id to mysql
            fileService.deleteFile(id, filename);

            //update files to user
            List<FileName> fileNames = fileService.getFileNames(user);
            request.getSession().setAttribute("files", fileNames);

            //test
            System.out.println(user.getId() + " delete file:" + file + "/" + filename);

            response.sendRedirect("pages/main.jsp");
        }
    }
}
