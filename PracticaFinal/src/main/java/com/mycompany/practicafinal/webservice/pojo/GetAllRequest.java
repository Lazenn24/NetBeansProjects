/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice.pojo;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author admin
 */
public class GetAllRequest {
    
    private String user;
    
    private String password;

    public GetAllRequest() {
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(password.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            this.password = hashtext;
        } // For specifying wrong message digest algorithms 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
