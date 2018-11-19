/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

/**
 *
 * @author admin
 */
public class UserPass {
    
    String user;
    
    String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public boolean compararUserPass(String user, String pass){
        return this.user.equals(user) && this.pass.equals(pass);
    }
    
    public boolean compararUser(String user){
            return this.user.equals(user);
    }
    
    
}
