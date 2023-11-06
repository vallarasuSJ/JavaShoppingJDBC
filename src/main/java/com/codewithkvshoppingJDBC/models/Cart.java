package com.codewithkvshoppingJDBC.models;

import java.util.ArrayList;

public class Cart {
    private String id;

    private String productName;

    private String email;

    private ArrayList<CartProduct>cartProducts;

    private int count;

    public ArrayList<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(ArrayList<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setCount(int count) {
    }
    public int getCount() {
        return count;
    }


}
