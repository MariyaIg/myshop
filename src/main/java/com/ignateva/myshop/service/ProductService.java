package com.ignateva.myshop.service;

import com.ignateva.myshop.DBManager;
import com.ignateva.myshop.entity.Order;
import com.ignateva.myshop.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ProductService {

    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try (Connection connection = DBManager.createConnection();
             Statement statement=connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT*from products");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int price = resultSet.getInt(4);
                products.add(new Product(id,title,description,price));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }


}



