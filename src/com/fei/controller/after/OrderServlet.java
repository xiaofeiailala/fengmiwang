package com.fei.controller.after;

import com.fei.bean.Order;
import com.fei.controller.BaseServlet;
import com.fei.service.after.OrderService;
import com.fei.service.after.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Order/*")
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageNo = request.getParameter("pageNo");
        List<Order> orders = orderService.orderQuery(pageNo);
        long count = orderService.orderCount();
        if (pageNo != null) {
            request.setAttribute("pageNo", pageNo);
        } else {
            request.setAttribute("pageNo", 1);
        }
        request.setAttribute("pageCount",count);
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);
    }
}
