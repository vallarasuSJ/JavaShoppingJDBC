package com.codewithkvshoppingJDBC.view;

import com.codewithkvshoppingJDBC.Utils.StringUtil;

import static com.codewithkvshoppingJDBC.Utils.Utils.println;

public class HomePage {


    public void printMenu() {
        println(StringUtil.WELCOME_MESSAGE);
        println(StringUtil.HOME_MENU);
    }
}
