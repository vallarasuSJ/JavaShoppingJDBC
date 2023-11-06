package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.StringUtil;
import com.codewithkvshoppingJDBC.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.FileUtil.getCartFile;
import static com.codewithkvshoppingJDBC.Utils.UserUtils.getLoggedInUser;
import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class CartPage {

    private  final Connection connection;

    public CartPage() {
        connection= DbConnection.getConnection();
    }

    public void printCart() {

        println(StringUtil.CART_MESSAGE);
        println(StringUtil.CART_MENU);

        String SELECT_CART="SELECT id,userEmail,product,count FROM cart where userEmail=?;";

        try {
            User loggedUser=getLoggedInUser();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CART);
            preparedStatement.setString(1,loggedUser.getEmail());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("userEmail") + " " + resultSet.getString("product") + " " + resultSet.getInt("count"));
            }
            println(StringUtil.CHECK_OUT);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void checkout(){
        println(StringUtil.CHECK_OUT);
    }
}
