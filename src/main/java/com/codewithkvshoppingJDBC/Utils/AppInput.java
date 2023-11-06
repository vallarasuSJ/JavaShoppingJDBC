package com.codewithkvshoppingJDBC.Utils;

import java.util.InputMismatchException;

import static com.codewithkvshoppingJDBC.Utils.AppScanner.getScanner;

public class AppInput {
   public static String enterString(String msg) {
       Utils.print(msg);
       return getScanner().nextLine();

   }

   public static int enterInt(String msg) throws AppException {
       Utils.print(msg);
       int input;
       try{
           input= Integer.parseInt(getScanner().nextLine());
       }
       catch(InputMismatchException e){
           throw new AppException(StringUtil.INVALID_CHOICE);
       }
       return input;
   }
}
