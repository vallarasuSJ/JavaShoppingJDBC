package com.codewithkvshoppingJDBC.controller;


import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.models.User;
import com.codewithkvshoppingJDBC.view.OrdersPage;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.FileUtil.*;
import static com.codewithkvshoppingJDBC.Utils.UserUtils.getLoggedInUser;

public class OrderController  {


    private final HomeController homeController;

    private  final Connection connection;

    public OrderController(HomeController homeController) {
        this.homeController = homeController;
        connection= DbConnection.getConnection();

    }



    public void checkout() {
        User loggedUser=getLoggedInUser();
        String SELECT_CART ="SELECT * FROM cart;";
        String INSERT_ORDER="INSERT into orders(id,email,product) VALUES (?,?,?);";
        String UPDATE_CART="UPDATE cart SET delete_flag=true WHERE id=? and product=? ";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CART);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getString("userEmail").equals(loggedUser.getEmail())){
                    System.out.println("success");
                    PreparedStatement ps=connection.prepareStatement(INSERT_ORDER);
                    ps.setInt(1,resultSet.getInt("id"));
                    ps.setString(2,loggedUser.getEmail());
                    ps.setString(3,resultSet.getString("product"));
                    int addRow=ps.executeUpdate();
                }
            }
            homeController.printMenu();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void ClearCart() throws IOException {
        FileInputStream inputStream= new FileInputStream(getFile());
        FileOutputStream outputStream=new FileOutputStream(getCartFile());

        int i;
        while((i=inputStream.read())!=-1){
            outputStream.write(i);
     }
        outputStream.close();
        inputStream.close();
    }


    public void showOrders() {
        OrdersPage.printOrder(connection);
        homeController.printMenu();


    }
}
