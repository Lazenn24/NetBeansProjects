/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

import com.mycompany.fichar.Password;
import com.mycompany.fichar.Email;
import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Local
public interface EJBSignUpLocal {
    
    @Size(min = 5, max = 20, message="El usuario debe contener entre 5 y 20 carácteres")
    @NotNull
    public String getUser();
    
    public void setUser(String user);
    
    @Password(message="La contraseña no cumple los requisitos")
    @NotNull
    public String getPassword();
    
    public void setPassword(String password);
    
    @Email(message="El email no es correcto")
    public String getEmail();
    
    public void setEmail(String email);
    
}
