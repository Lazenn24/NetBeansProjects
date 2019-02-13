/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.servlets.ejb;

import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Local
public interface EJBSignUpLocal extends EJBLoginLocal {
    
    @Size(min = 5, max = 20, message="El usuario debe contener entre 5 y 20 carácteres")
    @NotNull(message="Debes escribir un usuario")
    @Override
    public String getUser();
    
    @Override
    public void setUser(String user);
    
    @Password(message="La contraseña no cumple los requisitos")
    @NotNull(message="Debes escribir una contraseña")
    @Override
    public String getPassword();
    
    /**
     *
     * @param password
     */
    @Override
    public void setPassword(String password);
    
    @Email(message="El email no es correcto")
    @NotNull(message="Debes escribir un email")
    public String getEmail();
    
    public void setEmail(String email);
    
}
