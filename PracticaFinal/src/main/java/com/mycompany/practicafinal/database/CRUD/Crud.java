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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
public class Crud {

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

    public static boolean login(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        Query query = sesion.getNamedQuery("QueryLogin");
        query.setParameter("user", user.getUser());
        query.setParameter("password", user.getPassword());

        if (query.list().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkUser(String user, Session sesion) {

        Query query = sesion.getNamedQuery("User.findByUser");
        query.setParameter("user", user);

        if (query.list().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkEmail(String email, Session sesion) {

        Query query = sesion.getNamedQuery("User.findByEmail");
        query.setParameter("email", email);

        if (query.list().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

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

    public static boolean checkLastRegister(String user, EntradaSalida es) {

        List<Schedule> horario = getSchedule(user);

        if (horario.size() != 0) {
            Schedule checkRegister = horario.get(horario.size() - 1);

            if (checkRegister.getTypeOfRegister().equals(es)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

}
