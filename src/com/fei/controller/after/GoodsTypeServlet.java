package com.fei.controller.after;

import com.fei.bean.GoodsType;
import com.fei.controller.BaseServlet;
import com.fei.service.after.GoodsTypeService;
import com.fei.service.after.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsType/*")
public class GoodsTypeServlet extends BaseServlet {

    private GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageNo = request.getParameter("pageNo");
        List<GoodsType> goodsTypes = goodsTypeService.goodsTypes(pageNo);
        long count = goodsTypeService.goodsTypeCount();
        if (pageNo != null){
            request.setAttribute("pageNo",pageNo);
        }else {
            request.setAttribute("pageNo",1);
        }
        request.setAttribute("pageCount",count);
        request.setAttribute("goodsTypes",goodsTypes);

        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String typeName = request.getParameter("typeName");
        GoodsType goodsType = new GoodsType(typeName);
        boolean flag = goodsTypeService.goodsTypeAdd(goodsType);
        long count = goodsTypeService.goodsTypeCount();
        if (flag){
            response.sendRedirect(contextPath + "/GoodsType/query?pageNo=" + count);
        }
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        String typeName = request.getParameter("typeName");
        String pageNo = request.getParameter("pageNo");
        GoodsType goodsType = new GoodsType(Integer.parseInt(id),typeName);
        boolean flag = goodsTypeService.goodsTypeUpdate(goodsType);
        if (flag){
            response.sendRedirect(contextPath + "/GoodsType/query?pageNo=" + pageNo);
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        String pageNo = request.getParameter("pageNo");
        boolean flag = goodsTypeService.goodsTypeDelete(id);
        if (flag){
            response.sendRedirect(contextPath + "/GoodsType/query?pageNo=" + pageNo);
        }
    }
    public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
