package com.fei;

import com.alibaba.fastjson.JSON;
import com.fei.bean.GoodsType;
import com.fei.service.after.GoodsTypeService;
import com.fei.service.after.impl.GoodsTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestServlet", value = "/a")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);
//        String s = JSON.toJSONString(new String("1"));
//        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
//        List<GoodsType> goodsTypes = goodsTypeService.selectAll();
//        String toJSONString = JSON.toJSONString(goodsTypes);
//        System.out.println(s);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("{\"username\": \"杜二宁\"}");
    }
}
