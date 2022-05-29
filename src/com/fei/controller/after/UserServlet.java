package com.fei.controller.after;

import com.fei.bean.User;
import com.fei.controller.BaseServlet;
import com.fei.service.after.UserService;
import com.fei.service.after.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/User/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageNo = request.getParameter("pageNo");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        //System.out.println(pageNo+username+sex);
        List<User> users = userService.queryUsers(pageNo,username,sex);
        long count = userService.userCount(username, sex);
        //System.out.println(users);
        //System.out.println(count);
        request.setAttribute("users",users);
        request.setAttribute("pageCount",count);
        request.setAttribute("pageNo",pageNo);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);
    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String contextPath = request.getContextPath();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        User user = new User(username, password, phone, null, null, mail, null, null);
        boolean flag = userService.addUser(user);
        long count = userService.userCount(null, null);
        if (flag){
            response.sendRedirect(contextPath + "/User/query?pageNo=" + count);
        }
    }

    public void Delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        String pageNo = request.getParameter("pageNo");
        boolean flag = userService.deleteUser(Integer.parseInt(id));
        if (flag){
            response.sendRedirect(contextPath + "/User/query?pageNo=" + pageNo);
        }
    }
    public void Reset (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String pageNo = request.getParameter("pageNo");
        boolean flag = userService.updatePassword(password,Integer.parseInt(id));
        if (flag){
            response.sendRedirect(contextPath + "/User/query?pageNo=" + pageNo);
        }
    }
}
