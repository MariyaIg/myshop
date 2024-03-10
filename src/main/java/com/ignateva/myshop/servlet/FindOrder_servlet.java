package com.ignateva.myshop.servlet;


import com.ignateva.myshop.ProductService;
import com.ignateva.myshop.entity.Order;
import com.ignateva.myshop.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FindOrder_servlet", value = "/findOrder-servlet")

public class FindOrder_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/FindOrder.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("number1"));
        ProductService productService=new ProductService();
        ArrayList<Order> orders;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        orders= productService.getOrder(a);
        out.println("<h1> информация о заказе "+ a+"<h1><br>");
        out.println("<h1> <tr> <th >Дата  </th><th >Наименование  </th> <th >Описание  </th><th >Количество  </th> <th >  Цена</th> </tr><h1><br>");
        for(Order order: orders)
        {
            out.println("<td>"+ order.getDate()+", </td>");
            out.println("<td>"+ order.getTitle()+", </td>");
            out.println("<td>"+ order.getDescription()+", </td>");
            out.println("<td>"+ order.getAmount()+"шт, </td>");
            out.println("<td>"+ order.getPrice()+" рублей</td><br>");
            out.print("<br>");
        }


    }
}