package com.codewithkvshoppingJDBC.controller;

import com.codewithkvshoppingJDBC.Utils.AppException;
import com.codewithkvshoppingJDBC.Utils.StringUtil;
import com.codewithkvshoppingJDBC.view.HomePage;

import static com.codewithkvshoppingJDBC.Utils.AppInput.enterInt;
import static com.codewithkvshoppingJDBC.Utils.UserUtils.setLoggedInUser;

public class HomeController {
    private final HomePage homePage;

    private final AuthController authController;

    private final CategoryController categoryController;

    private final ProductController productController;

    private final CartController cartController;
    private final OrderController orderController;

    public HomeController(AuthController authController) {
        homePage = new HomePage();
        this.authController = authController;
        categoryController = new CategoryController(this);
        productController = new ProductController(this);
        cartController = new CartController(this);
        orderController = new OrderController(this);
    }


    public void printMenu() {
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 1) {
                categoryController.printMenu();
            } else if (choice == 2) {
                productController.showProducts();
            } else if (choice == 3) {
                cartController.showCart();
            } else if (choice == 4) {
                orderController.showOrders();
            } else if (choice == 5) {
                setLoggedInUser(null);
                authController.authMenu();
            }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }

    }
}
