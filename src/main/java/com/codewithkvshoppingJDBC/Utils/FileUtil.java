package com.codewithkvshoppingJDBC.Utils;

import java.io.File;

public class FileUtil {
    private static File credentialsFile;

    private static File categoryFile;

    private static  File productsFile;


    private  static File cartFile;

    private static File orderFile;
    private  static  File TcartFile;

    public static File getCredentialsFile(){
        if(credentialsFile==null){
            credentialsFile=new File("src/main/java/com/codewithkv/assets/credentials.csv");
        }
        return credentialsFile;
    }

    public static File getCategoryMenu() {
        if(categoryFile==null){
            categoryFile=new File("src/main/java/com/codewithkv/assets/Category.csv");
        }
        return categoryFile;
    }

    public static File getProductsMenu() {
        if (productsFile == null) {
            productsFile=new File("src/main/java/com/codewithkv/assets/products.csv");
        }
        return productsFile;
    }

    public static File getFile() {
        if(TcartFile==null){
            TcartFile=new File("src/main/java/com/codewithkv/assets/Tcart.csv");
        }
        return TcartFile;
    }

    public static File getOrder() {
        if(orderFile==null){
            orderFile=new File("src/main/java/com/codewithkv/assets/Orders.csv");
        }
        return orderFile;
    }


    public static File getCartFile(){
        if(cartFile==null){
            cartFile=new File("src/main/java/com/codewithkv/assets/Cart.csv");
        }

        return cartFile;
    }
}
