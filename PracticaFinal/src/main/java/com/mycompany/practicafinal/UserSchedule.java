/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author root
 */
public class UserSchedule {
    
    /*Tipo (E/S), user, timestamp
        E | usuario1 | 00:00:00
        S | usuario1 | 00:00:01
    */

    public UserSchedule(EntradaSalida tipo, String user, GregorianCalendar calendar) {
        this.tipo = tipo;
        this.user = user;
        this.calendar = calendar;
    }
    
    private EntradaSalida tipo;

    public EntradaSalida getTipo() {
        return tipo;
    }

    public void setTipo(EntradaSalida tipo) {
        this.tipo = tipo;
    }
        
    private String user;

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
     * @param id new value of user
     */
    public void setId(String user) {
        this.user = user;
    }
    
    private GregorianCalendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(GregorianCalendar calendar) {
        this.calendar = calendar;
    }




}
