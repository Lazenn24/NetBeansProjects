/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamundo;

import javax.ejb.Local;
import javax.validation.constraints.Min;

/**
 *
 * @author admin
 */
@Local
public interface StatefulBeanLocal {
    
    @Min(value=18, message="Tienes que ser mayor de edad")
    public int getEdad();
    
    public void setEdad(String edad);
    
    @Password(message = "Password incorrecto")
    public String getPassword();
    
    public void setPassword(String password);
    
    @DNI(message = "DNI incorrecto")
    public String getDNI();
    
    public void setDNI(String DNI);
    
}
