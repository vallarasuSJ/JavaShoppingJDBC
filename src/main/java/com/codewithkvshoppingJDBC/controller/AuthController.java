package com.codewithkvshoppingJDBC.controller;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.*;
import com.codewithkvshoppingJDBC.models.Role;
import com.codewithkvshoppingJDBC.models.User;
import com.codewithkvshoppingJDBC.view.LoginPage;
import com.codewithkvshoppingJDBC.view.RegisterPage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.AppInput.enterInt;
import static com.codewithkvshoppingJDBC.Utils.AppInput.enterString;
import static com.codewithkvshoppingJDBC.Utils.FileUtil.getCredentialsFile;
import static com.codewithkvshoppingJDBC.Utils.UserUtils.setLoggedInUser;
import static com.codewithkvshoppingJDBC.Utils.Utils.println;




public class AuthController  {
    private final Connection connection;

    private final HomeController homeController;

    private final AppController appController;

    private final LoginPage loginPage;

    private final RegisterPage registerPage;


    public AuthController(AppController appController) {
        this.appController = appController;
        homeController = new HomeController(this);

        loginPage = new LoginPage();

        registerPage = new RegisterPage();

        connection=DbConnection.getConnection();
    }


    public void authMenu() {
        appController.printAuthMenu();
        int choice;
        try {
            choice = enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }


    }

    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        authMenu();
    }

    public void login() {
        String email, password;
        email = enterString(StringUtil.ENTER_EMAIL);
        password = enterString(StringUtil.ENTER_PASSWORD);
        User user = validateUser(email, password);
        if (user != null) {
            setLoggedInUser(user);
            homeController.printMenu();
        } else {
            loginPage.printInvalidCredentials();
            authMenu();
        }


    }

    private String SELECT_QUERY="SELECT id,email,password from auth WHERE email=? AND password=?;";

    private User validateUser(String email, String password) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User user=new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                System.out.println(user);
                if(user.getEmail().equals("admin@gmail.com")){
                    user.setRole(Role.ADMIN);
                }
                else{
                    user.setRole(Role.USER);
                }
                return user;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void register() {
        String REGISTER_USER="INSERT INTO auth (email,password) VALUES (?,?);";
        String email, password, name, confirmPassword;
        name = enterString(StringUtil.ENTER_NAME);
        email = enterString(StringUtil.ENTER_EMAIL);
        password = enterString(StringUtil.ENTER_PASSWORD);
        confirmPassword = enterString(StringUtil.ENTER_PASSWORD_AGAIN);

        if (password.equals(confirmPassword)) {
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(REGISTER_USER);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);
                int result=preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            registerPage.passwordMismatch();
        }
        authMenu();
    }

    public void logout() {

    }

}
