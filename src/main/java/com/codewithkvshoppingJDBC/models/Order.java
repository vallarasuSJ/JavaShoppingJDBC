package com.codewithkvshoppingJDBC.models;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Cart> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cart> cart) {
        this.cart = cart;
    }

    private Date date;


    private ArrayList<Cart> cart;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public ArrayList<Cart> getCartProducts() {
        return cart;
    }

    public void setCartProducts(ArrayList<Cart> cartProducts) {
        this.cart = cartProducts;
    }
}
