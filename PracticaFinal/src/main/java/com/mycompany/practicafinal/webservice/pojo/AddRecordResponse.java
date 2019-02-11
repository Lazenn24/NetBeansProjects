/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice.pojo;

import com.mycompany.practicafinal.database.Entities.Schedule;

/**
 *
 * @author admin
 */
public class AddRecordResponse {

    private Schedule schedule;

    private String status;

    public AddRecordResponse() {
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
