package com.codewithkvshoppingJDBC.controller;


import com.codewithkvshoppingJDBC.view.WelcomePage;

public class AppController  {
    private final WelcomePage welcomePage;

    private final AuthController authController;



    public AppController(){
        welcomePage=new WelcomePage();
        authController=new AuthController(this);
    }



    public void init() {
        welcomePage.welcome();
        authController.authMenu();
    }


    public void printAuthMenu() {
        welcomePage.printAuthMenu();
    }


}
