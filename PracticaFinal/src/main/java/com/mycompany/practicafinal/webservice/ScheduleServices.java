/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice;

import com.mycompany.practicafinal.database.Entities.Schedule;
import static com.mycompany.practicafinal.webservice.CRUD.Crud.getSchedules;
import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
import com.mycompany.practicafinal.webservice.pojo.GetAllResponse;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author admin
 */
@Path("/schedule")
public class ScheduleServices {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GetAllResponse getAll(GetAllRequest gar) {
        
         return getSchedules(gar);        
    }

}
