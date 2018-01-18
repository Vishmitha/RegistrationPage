package com.example.admin.registrationpage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 17-Jan-18.
 */

public class Validation {

    boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    boolean isValidPassword(String pass) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);

        if (!pass.isEmpty() && pass.length()==10) {
            return matcher.matches();
        }
        return false;



    }
    boolean isValidNumber(String num)
    {
        if (!num.isEmpty() && num.length()==10) {
            return true;
        }
        return false;
    }
    boolean isValidName(String name) {
        if (!name.isEmpty()&& name.length()<=10 ) {
            return true;
        }



        return false;
    }
        boolean isValidFaxno(String name)
        {
            if (!name.isEmpty() && name.length()<14) {
                return true;
            }
            return false;
        }
        boolean isValidAddress(String name)
        {
            if (!name.isEmpty() && name.length()<200) {
                return true;
            }
            return false;
        }
    }

