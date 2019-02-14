/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.database.CRUD;

import com.mycompany.practicafinal.HibernateUtil;
import com.mycompany.practicafinal.database.Entities.Schedule;
import com.mycompany.practicafinal.database.Entities.User;
import java.util.List;
import com.mycompany.practicafinal.EntradaSalida;
import com.mycompany.practicafinal.webservice.pojo.AddRecordRequest;
import com.mycompany.practicafinal.webservice.pojo.AddRecordResponse;
import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
import com.mycompany.practicafinal.webservice.pojo.GetAllResponse;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
public class Crud {

    // Inserta los usuarios del registro
    public static String insertUser(User user) {

        String resultado = "";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        sesion.beginTransaction();
        if (checkUser(user.getUser(), sesion) && checkEmail(user.getEmail(), sesion)) {
            sesion.save(user);
            resultado = "Te has registrado correctamente";
        } else if (!checkUser(user.getUser(), sesion)) {
            resultado = "Ya existe un usuario con ese nombre";
        } else if (!checkEmail(user.getEmail(), sesion)) {
            resultado = "Ya existe un usuario con ese email";

        } else if (!checkEmail(user.getEmail(), sesion) && !checkUser(user.getUser(), sesion)) {
            resultado = "Ya existe un usuario con ese nombre y email";

        }
        sesion.getTransaction().commit();
        sesion.close();

        return resultado;

    }

    // Comprueba que los datos de usuario y contraseña(ya codificados) existan en la BBDD
    public static boolean login(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        Query query = sesion.getNamedQuery("QueryLogin");
        query.setParameter("user", user.getUser());
        query.setParameter("password", user.getPassword());

        return !query.list().isEmpty();
    }

    // Añade una entrada o salida al usuario
    public static void punchIn(Schedule schedule, String user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        int id = getUserId(user);

        schedule.setUser(new User(id));

        sesion.beginTransaction();

        sesion.save(schedule);

        sesion.getTransaction().commit();

        sesion.close();
    }
    
    // Devuelve una lista con todas las entradas y salidas del usuario
    public static List<Schedule> getSchedule(String user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        int userId = getUserId(user);

        Query query = sesion.getNamedQuery("Schedule.findByUser");
        query.setParameter("user", new User(userId));
        List<Schedule> horarios = query.list();

        sesion.close();

        return horarios;
    }

    // Comprueba el tipo del tipo del ultimo registro del usuario
    public static boolean checkLastRegister(String user, EntradaSalida es) {

        List<Schedule> horario = getSchedule(user);

        if (!horario.isEmpty()) {
            Schedule checkRegister = horario.get(horario.size() - 1);

            return !checkRegister.getTypeOfRegister().equals(es);
        } else {
            return true;
        }
    }

    // Comprueba si ya existe ese usuario
    private static boolean checkUser(String user, Session sesion) {

        Query query = sesion.getNamedQuery("User.findByUser");
        query.setParameter("user", user);

        return query.list().isEmpty();
    }

    // Comprueba si ya existe ese email
    private static boolean checkEmail(String email, Session sesion) {

        Query query = sesion.getNamedQuery("User.findByEmail");
        query.setParameter("email", email);

        return query.list().isEmpty();
    }

    // Proporciona la id del usuario para poder extraer sus horarios
    private static int getUserId(String user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        Query query = sesion.getNamedQuery("User.findByUser");
        query.setParameter("user", user);
        List<User> users = query.list();
        int id = users.get(0).getId();

        sesion.close();

        return id;
    }
    
    public static List<Object[]> getAllSchedules(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        
        Query query = sesion.createQuery("SELECT u.user, s.typeOfRegister, s.date FROM User u, Schedule s WHERE u.id = s.user order by u.user desc");
        List horarios = query.list();
        return horarios;
    }

    // Métodos para webservices
    
    // Devuelve todos los horarios de ese usuario, junto a un mensaje informativo
    public static GetAllResponse getScheduleWS(GetAllRequest gar) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        if (login(new User(gar.getUser(), gar.getPassword()))) {

            int userId = getUserId(gar.getUser());
            Query query = sesion.getNamedQuery("Schedule.findByUser");
            query.setParameter("user", new User(userId));
            List<Schedule> horarios = query.list();

            sesion.close();

            return new GetAllResponse("OK", horarios);
        } else {

            return new GetAllResponse("Login fallido");
        }
    }

    // Añade una entrada o salida a los horarios de ese usuario, y ademas lo devuelve, junto a un mensaje informativo
    public static AddRecordResponse punchInWS(AddRecordRequest arq) {
        if (login(new User(arq.getUser(), arq.getPassword()))) {

            if (checkLastRegister(arq.getUser(), arq.getTypeOfRegister())) {

                Schedule schedule = new Schedule(arq.getTypeOfRegister(), new Date(), new User(getUserId(arq.getUser())));
                punchIn(schedule, arq.getUser());
                return new AddRecordResponse(schedule, "OK");
            } else {

                if (arq.getTypeOfRegister() == EntradaSalida.ENTRADA) {
                    return new AddRecordResponse("Debes fichar salida antes");
                } else if (arq.getTypeOfRegister() == EntradaSalida.SALIDA) {
                    return new AddRecordResponse("Debes fichar entrada antes");
                }

            }
        }
        return new AddRecordResponse("Login fallido");

    }

}
