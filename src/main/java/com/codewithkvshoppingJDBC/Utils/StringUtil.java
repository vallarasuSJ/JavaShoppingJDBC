package com.codewithkvshoppingJDBC.Utils;

public class StringUtil {



    static String RESET = "\u001B[0m";

    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String BLUE = "\u001B[34m";
    static String BOLD = "\u001B[1m";
    static String UNDERLINE = "\u001B[4m";
    static String YELLOW = "\u001B[33m";

    public static final String INVALID_CHOICE = RED + "Invalid choice!!! please enter valid input" + RESET;

    public static final String INVALID_CREDENTIALS = RED+ "*------Invalid credentials-------*" + RESET;
    public static final String WELCOME_MESSAGE = BLUE + "Welcome to Java shopping!!" + RESET;
    public static final String AUTH_MENU = "1.Login\n2.Register";
    public static final String ENTER_CHOICE = "Please enter your choice: ";
    public static final String ENTER_EMAIL = "Please enter your email: ";
    public static final String ENTER_PASSWORD = "Please enter your password: ";
    public static final String ENTER_NAME = "Please enter your name: ";

    public static final String ENTER_PASSWORD_AGAIN = "Please enter your password again: ";
    public static final String REGISTRATION_SUCCESSFUL = GREEN+ "REGISTRATION SUCCESSFUL!!!" + RESET;
    public static final String PASSWORD_MISMATCH = RED +  "Password mismatch !!!" + RESET;
    public static final String CATEGORY_MENU = "Categories: ";
    public static final String HOME_MENU = "1. Categories\n2. Products\n3. Carts\n4. Orders\n5. Logout";
    public static final String PRODUCTS_MENU = "Products: ";
    public static final String PRODUCT_DETAILS = "ID PRODUCT PRICE" ;
    public static final String SUCCESS_MESSAGE = GREEN + "*------ Product added to cart successfully ------*" +RESET;
    public static final String CART_MESSAGE = "USER CART:" ;
    public static final String CART_MENU = "ID EMAIL PRODUCT COUNT";
    public static final String CHECK_OUT = YELLOW+ "88.checkout"+RESET;
    public static final String BACK_OPTION = YELLOW+ "99.Back" + RESET;
    public static final String ORDER_MESSAGE = "Your orders:";
    public static final String ORDER_PAGE = "ID PRODUCT";
}
