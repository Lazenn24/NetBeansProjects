/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.validator;

import javax.ejb.Local;

/**
 *
 * @author thepinguin
 */
@Local
public interface PostBeanLocal {
    
    public String getUser();
    public void setUser(String user);
    
    
    @Contrasena(message = "Faltan caracteres")
    public String getPasswrd();
    public void setPasswrd(String passwrd);

    @email(message = "Algo ha pasado")
    public String getMail();
    public void setMail(String mail);
    
}
