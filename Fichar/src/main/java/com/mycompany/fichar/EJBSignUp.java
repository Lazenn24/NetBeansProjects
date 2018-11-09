/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;


import javax.ejb.Stateful;


/**
 *
 * @author admin
 */
@Stateful
public class EJBSignUp implements EJBSignUpLocal {
    
    private String user;

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    private String password;
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    private String email;

    @Override
    public String getEmail() {
       return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    
}
