/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamundo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;

/**
 *
 * @author admin
 */
@Stateless
public class SessionBean1 implements SessionBean1Local {

    @Override
    public boolean isValidLength(String text) {
        return text.length() >= 6;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$"; //REGular EXpresion
        Pattern pattern = Pattern.compile(regex); //Compilar regex
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
