/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice;

import com.mycompany.practicafinal.webservice.pojo.AddRecordRequest;
import com.mycompany.practicafinal.webservice.pojo.AddRecordResponse;
import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
import com.mycompany.practicafinal.webservice.pojo.GetAllResponse;
import static com.mycompany.practicafinal.database.CRUD.Crud.getScheduleWS;
import static com.mycompany.practicafinal.database.CRUD.Crud.punchInWS;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author admin
 */
@Path("/schedule")
public class ScheduleServices {

    // No se lo que hace esto pero asi no salen mas bombillas :D
    public ScheduleServices() {
        this.executorService = java.util.concurrent.Executors.newCachedThreadPool();
    }


    private final ExecutorService executorService;

    @POST
    @Path(value = "/getRecords")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getAll(@Suspended final AsyncResponse asyncResponse, final GetAllRequest gar) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetAll(gar));
            }
        });
    }

    private GetAllResponse doGetAll(GetAllRequest gar) {
        return getScheduleWS(gar);
    }

    @POST
    @Path(value = "/addRecord")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public void addRecord(@Suspended final AsyncResponse asyncResponse, final AddRecordRequest arq) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doAddRecord(arq));
            }
        });
    }

    private AddRecordResponse doAddRecord(AddRecordRequest arq) {
        return punchInWS(arq);
    }

}
