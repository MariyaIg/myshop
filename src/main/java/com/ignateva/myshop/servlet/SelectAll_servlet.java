package com.ignateva.myshop.servlet;

import com.ignateva.myshop.ProductService;
import com.ignateva.myshop.dao.ProductDao;
import com.ignateva.myshop.entity.Product;
import com.ignateva.myshop.exception.DaoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectAll_servlet", value ="/selectAll-servlet")
public class SelectAll_servlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  req.getRequestDispatcher("/SelectAll.jsp").forward(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ArrayList<Product> products;

       ProductService pd=new ProductService();
        try {
          products=pd.getAll();
            out.println("<html><body><h1>Магазин </h1>" +
                    "<table class=\"table\">");
            for(Product product: products)
            {
                out.println(product.getTitle());
                out.println(product.getDescription());
                out.println(product.getPrice());
                out.println("<br>");
            }

            out.println("</table></body></html>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}