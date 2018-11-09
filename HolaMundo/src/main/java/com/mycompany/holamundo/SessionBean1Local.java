/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamundo;

import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface SessionBean1Local {

    boolean isValidLength(String text);

    boolean isValidEmail(String email);
    
}
