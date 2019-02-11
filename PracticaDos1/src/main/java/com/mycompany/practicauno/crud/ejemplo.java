/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.crud;

import static com.mycompany.practicauno.crud.Crud.getMD5;
import com.mycompany.practicauno.datamodel.HibernateUtil;
import com.mycompany.practicauno.datamodel.entities.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author thepinguin
 */
public class ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        String hql = "FROM Usuario WHERE nombre = 'caput' and contrasenya = '{6Qtf1-rS[HvdtT@6-x]'";
        Query query = session.createQuery(hql);
        List<Usuario> usuarios = query.list();
        

        
        session.getTransaction().commit();
        
        
        session.close();
    }
    
}
