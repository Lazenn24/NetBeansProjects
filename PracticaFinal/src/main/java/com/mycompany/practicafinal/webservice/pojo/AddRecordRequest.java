/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice.pojo;

import com.mycompany.practicafinal.EntradaSalida;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author admin
 */
public class AddRecordRequest {

    private String user;

    private String password;

    private EntradaSalida typeOfRegister;

    public AddRecordRequest() {
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
        catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    public AddRecordRequest(String user, EntradaSalida typeOfRegister) {
        this.user = user;
        this.typeOfRegister = typeOfRegister;
    }

    public EntradaSalida getTypeOfRegister() {
        return typeOfRegister;
    }

    public void setTypeOfRegister(EntradaSalida typeOfRegister) {
        this.typeOfRegister = typeOfRegister;
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public String getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(String user) {
        this.user = user;
    }

}
