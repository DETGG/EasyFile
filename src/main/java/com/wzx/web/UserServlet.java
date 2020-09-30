package com.wzx.web;

import com.wzx.pojo.FileName;
import com.wzx.pojo.User;
import com.wzx.service.FileService;
import com.wzx.service.UserService;
import com.wzx.service.impl.FileServiceImpl;
import com.wzx.service.impl.UserServiceImpl;
import com.wzx.utils.WebUtils;
import com.wzx.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * User module:
 * login
 * register
 * change the inf
 * ...
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();
    private FileService fileService = new FileServiceImpl();

    /**
     * to login
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));//transport into int
        String password = request.getParameter("password");
        User user = userService.login(new User(id,password,null,null));
        if(user ==null){
            response.sendRedirect("/index.jsp");
        }else {
            //not to input id again
//            Cookie cookie = new Cookie("id",id.toString());
//            cookie.setMaxAge(60 * 60 * 24 * 7);
//            response.addCookie(cookie);

            //save the inf after login
            request.getSession().setAttribute("user",user);

            //send files belong to user
            List<FileName> list  = fileService.getFileNames(user);

            request.getSession().setAttribute("files",list);



            response.sendRedirect("/pages/main.jsp");
        }
    }

    /**
     * to register
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
          Integer id = Integer.parseInt(request.getParameter("id"));//transport into int
//          String username = request.getParameter("username");
      //    String password = request.getParameter("password");
          String email = request.getParameter("email");
          String code = request.getParameter("code");

        UserService userService = new UserServiceImpl();

        //dead code :abcde/ABcde/...
        if("abcde".equalsIgnoreCase(code)){
            if(userService.existID(id)||userService.existEmail(email)){
                System.out.println("exist id or email");
                response.sendRedirect("/pages/register_failed.jsp");

            }else {
                //an excellent simplify !!
                User user = WebUtils.copyParamToBean(request.getParameterMap(),new User());
                userService.registerUser(user);
                response.sendRedirect("/pages/register_success.html");
            }
        }else {
            System.out.println("false code");
            request.getRequestDispatcher("/pages/register.jsp").forward(request,response);
        }
    }
}
