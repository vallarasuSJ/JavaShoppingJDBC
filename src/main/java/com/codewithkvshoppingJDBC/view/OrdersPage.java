package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.StringUtil;
import com.codewithkvshoppingJDBC.models.User;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.FileUtil.getOrder;
import static com.codewithkvshoppingJDBC.Utils.UserUtils.getLoggedInUser;
import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class OrdersPage {

    private Connection connection;

    public OrdersPage() {
        connection = DbConnection.getConnection();
    }


    public static void printOrder(Connection connection) {
        String SELECT_ORDER = "SELECT * FROM orders;";
        println(StringUtil.ORDER_MESSAGE);
        println(StringUtil.ORDER_PAGE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("email") + " " + resultSet.getString("product"));
            }
            println(StringUtil.BACK_OPTION);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
