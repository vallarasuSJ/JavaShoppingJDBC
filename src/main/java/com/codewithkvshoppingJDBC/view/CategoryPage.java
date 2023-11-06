package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Do.DbConnection;
import com.codewithkvshoppingJDBC.Utils.StringUtil;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.codewithkvshoppingJDBC.Utils.FileUtil.getCategoryMenu;
import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class CategoryPage {

    private final Connection connection;

    public CategoryPage() {
        connection = DbConnection.getConnection();
    }


    public static void categoryMenu(Connection connection) {
        String SELECT_CATEGORY = "SELECT id,categoryName FROM category;";

        try {
            println(StringUtil.CATEGORY_MENU);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("categoryName"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
