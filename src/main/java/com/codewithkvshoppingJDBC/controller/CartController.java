package com.codewithkvshoppingJDBC.controller;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.*;

import com.codewithkvshoppingJDBC.models.Cart;
import com.codewithkvshoppingJDBC.models.User;
import com.codewithkvshoppingJDBC.view.CartPage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.AppInput.enterInt;
import static com.codewithkvshoppingJDBC.Utils.FileUtil.getCartFile;
import static com.codewithkvshoppingJDBC.Utils.UserUtils.getLoggedInUser;

public class CartController{

    private HomeController homeController;
    private final CartPage cartPage;
    private  final OrderController orderController;

    private final Connection connection;

    public CartController(HomeController homeController) {
        this.homeController = homeController;
        cartPage = new CartPage();
        orderController=new OrderController(homeController);
        connection= DbConnection.getConnection();
    }

    ArrayList<Cart>carts=new ArrayList<>();


    public void addToCart(String productChoice) {
        String UPDATE_COUNT="UPDATE cart SET count=count+1 WHERE id=? and product=? ";
        String INSERT_CART="INSERT INTO cart(id,userEmail,product) VALUES (?,?,?)";
        String SELECT_PRODUCTS="SELECT * from products;";
        String SELECT_CART="SELECT product from cart where id=?; ";
        User loggedUser = getLoggedInUser();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_PRODUCTS);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("success");
            while(resultSet.next()){
                PreparedStatement p=connection.prepareStatement(SELECT_CART);
                p.setInt(1,resultSet.getInt("id"));
                ResultSet rs=p.executeQuery();
                if(resultSet.getInt("id")==Integer.parseInt(productChoice) && !rs.next() ){
                    PreparedStatement ps= connection.prepareStatement(INSERT_CART);
                    ps.setInt(1,resultSet.getInt("id"));
                    ps.setString(2, loggedUser.getEmail());
                    ps.setString(3,resultSet.getString("title"));
                    int addRow=ps.executeUpdate();
                    totalCount();
                }
                while(rs.next()){
                    if(rs.getString("product").equals(resultSet.getString("title"))){
                        PreparedStatement preparedStatement1=connection.prepareStatement(UPDATE_COUNT);
                        preparedStatement1.setString(1,resultSet.getString("id"));
                        preparedStatement1.setString(2,rs.getString("product"));
                        int addCount=preparedStatement1.executeUpdate();
                        System.out.println("failure");
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void totalCount() {
        int l=carts.size();
        for(int i=0;i<l-1;i++){
            System.out.println(carts.get(i).getProductName());
        }
    }



    public void showCart() {
        cartPage.printCart();

        try {
            int choice=enterInt(StringUtil.ENTER_CHOICE);
            if(choice==88){

                checkout();
            }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }

    }

    private void checkout() {

        orderController.checkout();
    }


}
