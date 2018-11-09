/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamundo;

import javax.ejb.Stateful;

/**
 *
 * @author admin
 */
@Stateful
public class StatefulBean implements StatefulBeanLocal {

     private int edad;

    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(String edad) {
        if(!"".equals(edad)) {
            this.edad = Integer.parseInt(edad);
        } else {
            this.edad = 0;
        }
    }
    
    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    private String DNI;

    /**
     * Get the value of DNI
     *
     * @return the value of DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Set the value of DNI
     *
     * @param DNI new value of DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }


}
