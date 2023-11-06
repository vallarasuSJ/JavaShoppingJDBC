package com.codewithkvshoppingJDBC.controller;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.StringUtil;

import com.codewithkvshoppingJDBC.view.ProductsPage;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.AppInput.enterString;
import static com.codewithkvshoppingJDBC.Utils.FileUtil.getProductsMenu;
import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class ProductController {
    private final HomeController homeController;
    private final ProductsPage productsPage;
    private final CartController cartController;

    private final Connection connection;

    public ProductController(HomeController homeController) {
        this.homeController = homeController;
        productsPage = new ProductsPage();
        cartController = new CartController(homeController);
        connection = DbConnection.getConnection();
    }


    public void showProducts() {
        String SELECT_PRODUCTS = "SELECT id,title,description,price FROM products;";
        productsPage.showProducts();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS);
            String productChoice = enterString(StringUtil.ENTER_CHOICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int choice = resultSet.getInt("id");
                if (choice == Integer.parseInt(productChoice)) {
                    cartController.addToCart(productChoice);
                    productsPage.printSuccess();
                    showProducts();
                }
            }
            if (productChoice.equals("99")) {
                homeController.printMenu();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void showProducts(int choice) {
        println(StringUtil.PRODUCTS_MENU);
        println(StringUtil.PRODUCT_DETAILS);
        String SELECT_PRODUCTS = "SELECT id,title,description,price FROM products;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") + " " + resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            String productChoice = enterString(StringUtil.ENTER_CHOICE);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS);
            if (productChoice == "99") {
                homeController.printMenu();
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                if (id == Integer.parseInt(productChoice)) {
                    cartController.addToCart(productChoice);
                    productsPage.printSuccess();
                    showProducts();

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




