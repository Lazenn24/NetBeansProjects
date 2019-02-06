/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice;

import com.mycompany.practicafinal.HibernateUtil;
import com.mycompany.practicafinal.database.Entities.Schedule;
import com.mycompany.practicafinal.database.Entities.User;
import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
import com.mycompany.practicafinal.webservice.pojo.GetAllResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
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
            return response;
        }

        response = new GetAllResponse();
        
        response.setMsg("NO OK");

        return response;

    }


}
