package com.ignateva.myshop;

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

    public ArrayList<Order> getOrder(int a) {

        String query = "select date, title,description,amount,price from product_order join Orders O on O.id = product_order.orderId join Products P on P.id = product_order.productId where number ="+a;
        ArrayList<Order> order = new ArrayList<>();
        try(Connection connection = DBManager.createConnection();
            Statement statement=connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Date date = resultSet.getDate(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int amount = resultSet.getInt(4);
                int price = resultSet.getInt(5);
                order.add(new Order(date,title,description,amount,price));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;

    }

    public ArrayList<Integer> getByTotalAmount(int a){
        ArrayList<Integer> orderTotal = new ArrayList<>();
        String query1="select number from product_order join Orders O on O.id = product_order.orderId join Products P on P.id = product_order.productId group by number having sum(price*amount)<=" +a;
        try(Connection connection = DBManager.createConnection();
            Statement statement=connection.createStatement();)  {
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                int number = resultSet.getInt(1);

                orderTotal.add(number);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderTotal;
    }

    public ArrayList<Integer> getByTotalQuantity(int b){
        ArrayList<Integer> orderQuantity = new ArrayList<>();
        String query2="select number from product_order join Orders O on O.id = product_order.orderId join Products P on P.id = product_order.productId group by number having sum(amount)="+b;
        try (Connection connection = DBManager.createConnection();
             Statement statement=connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(query2);
            while (resultSet.next()) {
                int number = resultSet.getInt(1);
                orderQuantity.add(number);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderQuantity;
    }

    public ArrayList<Integer> getByTitle(String prod_title){
        ArrayList<Integer> orders = new ArrayList<>();
        String query3="select number from product_order join Orders O on O.id = product_order.orderId join Products P on P.id = product_order.productId where title ="+"'"+prod_title+"'";
        try (Connection connection = DBManager.createConnection();
             Statement statement=connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(query3);
            while (resultSet.next()) {
                int number = resultSet.getInt(1);
                orders.add(number);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

}



