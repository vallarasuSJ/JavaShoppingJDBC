package com.codewithkvshoppingJDBC.controller;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.StringUtil;
import com.codewithkvshoppingJDBC.view.CategoryPage;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.AppInput.enterString;
import static com.codewithkvshoppingJDBC.Utils.FileUtil.getCategoryMenu;

public class CategoryController  {
    private final HomeController homeController;
    private  final ProductController productController;
    private  final Connection con;

    public CategoryController(HomeController homeController) {
        this.homeController=homeController;
        productController=new ProductController(homeController);
        con= DbConnection.getConnection();

    }

    public void printMenu() {
        String SELECT_CATEGORY = "SELECT id FROM category WHERE id=?;";
        String SELECT_PRODUCTS = "SELECT id,title,description,price FROM products;";
        CategoryPage.categoryMenu(con);
        String choice=enterString(StringUtil.ENTER_CHOICE);
        try {
            PreparedStatement preparedStatement= con.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
               int id=resultSet.getInt("id");
               if(id==Integer.parseInt(choice)){
                   productController.showProducts(id);
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
