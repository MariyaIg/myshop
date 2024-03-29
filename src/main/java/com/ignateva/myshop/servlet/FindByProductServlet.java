package com.ignateva.myshop.servlet;

import com.ignateva.myshop.service.OrderService;
import com.ignateva.myshop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FindByProductServlet", value="/findByProduct-servlet")
public class FindByProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/FindByProduct.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prod_title = req.getParameter("prod_title");
        OrderService orderService = new OrderService();
        ArrayList<Integer> orders;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        orders = orderService.getByTitle(prod_title);

        out.println("<h1> информация о заказах содержащих " + prod_title + "<h1><br>");
        for (int i = 0; i < orders.size(); i++) {
            out.println(orders.get(i));
        }

    }
}