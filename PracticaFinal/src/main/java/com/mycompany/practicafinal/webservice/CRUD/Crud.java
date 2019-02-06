/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice.CRUD;

import com.mycompany.practicafinal.HibernateUtil;
import com.mycompany.practicafinal.database.Entities.Schedule;
import com.mycompany.practicafinal.database.Entities.User;
import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
import com.mycompany.practicafinal.webservice.pojo.GetAllResponse;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
public class Crud {
    
    public static GetAllResponse getSchedules(GetAllRequest gar){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        Session sesion = sf.openSession();
        
        String checkUserHql = "FROM User u WHERE u.user = :user AND u.password = :password";
        
        Query checkUserQuery = sesion.createQuery(checkUserHql);
        checkUserQuery.setParameter("user", gar.getUser());
        checkUserQuery.setParameter("password", gar.getPassword());
        
        if(!checkUserQuery.list().isEmpty()){
            List<User> user = checkUserQuery.list();
            int id = user.get(0).getId();
            String getScheduleHql = "FROM Schedule s WHERE s.user = :user";
            Query getScheduleQuery = sesion.createQuery(getScheduleHql);
            getScheduleQuery.setParameter("user", new User(id));
            List<Schedule> horario = getScheduleQuery.list();
            GetAllResponse response = new GetAllResponse();
            response.setMsg("OK");
            response.setHorario(horario);
            return response;
        }
        return null;
    }
    
}
