/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice;

import com.mycompany.practicafinal.HibernateUtil;
import com.mycompany.practicafinal.database.Entities.Schedule;
import com.mycompany.practicafinal.database.Entities.User;
import com.mycompany.practicafinal.webservice.pojo.AddRecordRequest;
import com.mycompany.practicafinal.webservice.pojo.AddRecordResponse;
import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
import com.mycompany.practicafinal.webservice.pojo.GetAllResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
@Path("/schedule")
public class ScheduleServices {

    @POST
    @Path("/getRecords")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GetAllResponse getAll(GetAllRequest gar) {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session sesion = sf.openSession();

        GetAllResponse response;

        String checkUserHql = "FROM User u WHERE u.user = :user AND u.password = :password";

        Query checkUserQuery = sesion.createQuery(checkUserHql);
        checkUserQuery.setParameter("user", gar.getUser());
        checkUserQuery.setParameter("password", gar.getPassword());

        if (!checkUserQuery.list().isEmpty()) {
            List<User> user = checkUserQuery.list();
            int id = user.get(0).getId();
            String getScheduleHql = "FROM Schedule s WHERE s.user = :user";
            Query getScheduleQuery = sesion.createQuery(getScheduleHql);
            getScheduleQuery.setParameter("user", new User(id));
            List<Schedule> horario = getScheduleQuery.list();
            response = new GetAllResponse();
            response.setMsg("OK");
            response.setHorario(horario);
            sesion.close();
            return response;

        }

        response = new GetAllResponse();

        response.setMsg("NO OK");
        sesion.close();
        return response;

    }

    @POST
    @Path("/addRecord")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddRecordResponse addRecord(AddRecordRequest arq) {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session sesion = sf.openSession();

        String checkUserHql = "FROM User u WHERE u.user = :user AND u.password = :password";
        
        AddRecordResponse response;

        Query checkUserQuery = sesion.createQuery(checkUserHql);
        checkUserQuery.setParameter("user", arq.getUser());
        checkUserQuery.setParameter("password", arq.getPassword());

        if (!checkUserQuery.list().isEmpty()) {
            List<User> user = checkUserQuery.list();
            int id = user.get(0).getId();
            
            Schedule schedule = new Schedule(arq.getTypeOfRegister(), new Date(), new User(id));
            
            sesion.beginTransaction();
            
            sesion.save(schedule);
            
            sesion.getTransaction().commit();
            
            String getLastRecordHql = "FROM Schedule s WHERE s.user = :user";
            Query getLastRecordQuery = sesion.createQuery(getLastRecordHql);
            getLastRecordQuery.setParameter("user", new User(id));
            List<Schedule> schedules = getLastRecordQuery.list();
            
            response = new AddRecordResponse();
            
            response.setSchedule(schedules.get(schedules.size() -1));
            response.setStatus("OK");
            sesion.close();
            return response;
        } else {
            response = new AddRecordResponse();
            response.setStatus("No se ha podido logear");
            sesion.close();
            return response;
    }

}

}
