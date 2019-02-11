/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.validator;

import javax.ejb.Stateful;

/**
 *
 * @author thepinguin
 */
@Stateful
public class PostBean implements PostBeanLocal {

    private String user;
    
    private String passwrd;
    
    private String mail;

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPasswrd() {
        return passwrd;
    }

    @Override
    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
}
