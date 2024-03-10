package com.ignateva.myshop.servlet;

import com.ignateva.myshop.ProductService;
import com.ignateva.myshop.entity.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Amount_servlet", value="/amount-servlet")
public class Amount_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/FindByAmount.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("number1"));
        int b = Integer.parseInt(req.getParameter("number2"));
        ProductService productService = new ProductService();
        ArrayList<Integer> ordersByAmount;
        ArrayList<Integer> ordersByQuantity;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ordersByAmount = productService.getByTotalAmount(a);
        ordersByQuantity = productService.getByTotalQuantity(b);
        out.println("<h1> информация о заказах сумма не превышает " + a + "<h1><br>");
        for (int i = 0; i < ordersByAmount.size(); i++) {
            out.println(ordersByAmount.get(i));
        }

        out.println("<h1> информация о заказах количество товаров в которых " + b + "<h1><br>");

        for (int i = 0; i < ordersByQuantity.size(); i++) {
            out.println(ordersByQuantity.get(i));
        }

        out.println("<h1> информация о заказах выполняются оба условия <h1><br>");


        for (int i = 0; i < ordersByAmount.size(); i++)
        {
            int am = ordersByAmount.get(i);
            for (int j = 0; j < ordersByQuantity.size(); j++) {
                int quan = ordersByQuantity.get(j);
                if (am!=quan) continue;

                out.println(am);
                break;
            }

        }

    }
}