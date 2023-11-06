package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Utils.StringUtil;

import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class RegisterPage {

    public void printRegistrationSuccessful(){

        try {
            println(StringUtil.REGISTRATION_SUCCESSFUL);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void passwordMismatch()  {

        try {
            println(StringUtil.PASSWORD_MISMATCH);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
