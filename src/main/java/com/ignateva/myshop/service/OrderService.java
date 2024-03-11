package com.ignateva.myshop.service;

import com.ignateva.myshop.DBManager;
import com.ignateva.myshop.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class OrderService {

    public ArrayList<Order> getOrder(int a) {

        String query = "select date, title,description,amount,price from product_order join Orders O on O.id " +
                "= product_order.orderId join Products P on P.id = product_order.productId where number ="+a;
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
        String query1="select number from product_order join Orders O on O.id = product_order.orderId join " +
                "Products P on P.id = product_order.productId group by number having sum(price*amount)<=" +a;
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
        String query2="select number from product_order join Orders O on O.id = product_order.orderId join " +
                "Products P on P.id = product_order.productId group by number having sum(amount)="+b;
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
        String query3="select number from product_order join Orders O on O.id = product_order.orderId join" +
                " Products P on P.id = product_order.productId where title =?";
        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(query3);){
            preparedStatement.setString(1,prod_title);
            ResultSet resultSet = preparedStatement.executeQuery();
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



