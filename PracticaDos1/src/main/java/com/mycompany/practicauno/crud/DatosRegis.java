/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.crud;

import com.mycompany.practicauno.datamodel.HibernateUtil;
import com.mycompany.practicauno.datamodel.entities.Registros;
import com.mycompany.practicauno.datamodel.entities.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author thepinguin
 */
public class DatosRegis {
    
    
     public static ArrayList mediaHoras(Usuario us) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        
        
        String hql = "FROM Registros WHERE idUs ='" + us.getId() + "'";
        Query query = session.createQuery(hql);
        List<Registros> usuarios = query.list();
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        int divide = 0;
        
        long[] entradaYSalidas = {0, 0};
         int totalHoras = 0, totalMinutos = 0, totalSegundos = 0; 
         for (Registros u : usuarios) {
             
             
             
             if(u.getTipo().equals("entrada")){
                 
                 entradaYSalidas[0] = u.getFecha().getTime() / 1000;
             }else{
                 entradaYSalidas[1] = u.getFecha().getTime() / 1000;
                 
                 divide++;
                long diff = entradaYSalidas[1] - entradaYSalidas[0];
                        int horas = 0, minutos = 0, segundos;
                        
                        if(diff > 3600) {
                            horas = (int) Math.floor((diff / 60) / 60);
                            minutos = (int) Math.floor((diff / 60) % 60); 
                            segundos = (int) Math.floor(diff % 60);
                        }
                        else if(diff > 60 ){
                            minutos = (int) Math.floor(diff / 60); 
                            segundos = (int) Math.floor(diff % 60);
                        } 
                        else {
                            segundos = (int) Math.floor(diff);  
                        }
                     //    out.println("<td>" + horas + ":" + minutos + ":" + segundos + "</td>");
                        
                        totalHoras = totalHoras + horas; 
                        totalMinutos = totalMinutos + minutos;
                        
                        if(totalMinutos > 60) {
                            totalHoras = totalHoras + 1; 
                            totalMinutos = totalMinutos - 60; 
                        }
                        totalSegundos = totalSegundos + segundos;
                        if(totalSegundos > 60) {
                            totalMinutos = totalMinutos + 1; 
                            totalSegundos = totalSegundos - 60; 
                        }
                        
                      // out.println("<td>" + totalHoras + ":" + totalMinutos + ":" + totalSegundos + "</td>");
             }
             
         }
         
         ArrayList horrras = new ArrayList();
         horrras.add(totalHoras / divide);
         horrras.add(totalMinutos / divide);
         horrras.add(totalSegundos / divide);
         
         return horrras;
         
       
    }
}
