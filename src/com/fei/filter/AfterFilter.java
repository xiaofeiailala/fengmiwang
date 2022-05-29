package com.fei.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = { "*.jsp",
//        "/User/*",
//        "/Goods/*",
//        "/Order/*",
//        "/GoodsType/*",
//
//})
public class AfterFilter{
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        String contextPath = httpServletRequest.getContextPath();
//        HttpSession session = httpServletRequest.getSession();
//        //System.out.println(session);
//        Object name = session.getAttribute("name");
//        //System.out.println(name);
//        StringBuffer requestURL = httpServletRequest.getRequestURL();
//        // System.out.println(requestURL);
//        int index = requestURL.lastIndexOf("/");
//        String methodName = requestURL.substring(index + 1);
//        System.out.println(methodName + name);
//        System.out.println("11");
//        if (name != null || "login.jsp".equals(methodName)){
//            System.out.println("22");
//            chain.doFilter(httpServletRequest, httpServletResponse);
//        }else {
//            httpServletResponse.sendRedirect(contextPath + "/after/login.jsp");
//        }
//
//    }
}
