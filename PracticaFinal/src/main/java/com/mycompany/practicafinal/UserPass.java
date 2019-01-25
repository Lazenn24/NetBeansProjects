/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author admin
 */
public class UserPass {
    
    String user;
    
    String pass;
    
    String email;

    public UserPass() {
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    //Codifica la contraseña directamente
    public void setPass(String pass) {
         try { 
  
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            
            byte[] messageDigest = md.digest(pass.getBytes()); 
  
            BigInteger no = new BigInteger(1, messageDigest); 
  
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            this.pass = pass; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (Exception e) { 
            System.out.println(e.getMessage());
        } 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean compararUserPass(String user, String pass){
        return this.user.equals(user) && this.pass.equals(pass);
    }
    
    public boolean compararUser(String user){
            return this.user.equals(user);
    }
    
    
}
