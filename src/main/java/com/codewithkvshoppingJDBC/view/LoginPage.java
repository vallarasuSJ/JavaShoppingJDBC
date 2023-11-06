package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Utils.StringUtil;

import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class LoginPage {
    public void printInvalidCredentials(){

        try {
            println(StringUtil.INVALID_CREDENTIALS);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
