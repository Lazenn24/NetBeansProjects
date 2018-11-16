/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import sun.applet.Main;

/**
 *
 * @author admin
 */
public class pruebas {
    
    public static String ficharEntrada() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public static void main(String[] args) {
        
        System.out.println(ficharEntrada());
    }
    
}
