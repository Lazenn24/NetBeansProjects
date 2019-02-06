/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice.pojo;

import com.mycompany.practicafinal.database.Entities.Schedule;
import java.util.List;

/**
 *
 * @author admin
 */
public class GetAllResponse {
    
        private String msg;
        
    private List<Schedule> horario;

    /**
     * Get the value of horario
     *
     * @return the value of horario
     */
    public List<Schedule> getHorario() {
        return horario;
    }

    /**
     * Set the value of horario
     *
     * @param horario new value of horario
     */
    public void setHorario(List<Schedule> horario) {
        this.horario = horario;
    }


    /**
     * Get the value of msg
     *
     * @return the value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Set the value of msg
     *
     * @param msg new value of msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    
}
