package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.StringUtil;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.AppInput.enterString;
import static com.codewithkvshoppingJDBC.Utils.FileUtil.getProductsMenu;
import static com.codewithkvshoppingJDBC.Utils.Utils.println;




public class ProductsPage {
    private  final Connection connection;

    public ProductsPage( ) {
        connection= DbConnection.getConnection();
    }

    public void showProducts(){
        String SELECT_PRODUCTS = "SELECT id,title,description,price FROM products;";
        println(StringUtil.PRODUCTS_MENU);
        println("---------------------------");
        println(" ");
        println(StringUtil.PRODUCT_DETAILS);
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_PRODUCTS);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title")  + " " + resultSet.getInt("price"));
            }
            println(StringUtil.BACK_OPTION);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void printSuccess() {
        println(StringUtil.SUCCESS_MESSAGE);
    }
}
