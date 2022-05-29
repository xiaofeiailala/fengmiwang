package com.fei.controller.after;

import com.fei.controller.BaseServlet;
import com.fei.service.after.AdminService;
import com.fei.service.after.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/Admin/*")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminServiceImpl();

    public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String contextPath = request.getContextPath();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
       // System.out.println(session);
        session.setAttribute("name",username);
        boolean flag = adminService.login(username, password);
        if (flag){
            response.sendRedirect(contextPath + "/User/query?pageNo=1");
        }else {
            response.sendRedirect(contextPath + "/after/login.jsp");
        }
    }

    public void quit(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String contextPath = request.getContextPath();
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect(contextPath + "/after/login.jsp");
    }
}
