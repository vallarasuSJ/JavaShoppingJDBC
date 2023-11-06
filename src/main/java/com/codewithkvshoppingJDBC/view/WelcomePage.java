package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Utils.StringUtil;

import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class WelcomePage {

    public void welcome() {
        println(StringUtil.WELCOME_MESSAGE);
    }

    public void printAuthMenu() {
        println(StringUtil.AUTH_MENU);
    }
}
