/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfultest.webservice;

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
import com.mycompany.restfultest.datamodel.HibernateUtil;
import com.mycompany.restfultest.datamodel.entities.Book;

/**
 *
 * @author admin
 */
@Path("/book")
public class BookService {
    
    // Service para obtener libros, añadir libros, etc
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        
        String hql = "from Book b";
        Query query = ses.createQuery(hql);
        List<Book> books = query.list();
        ses.close();
        return books;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Book book){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        
        ses.beginTransaction();
        ses.save(book);
        
        ses.getTransaction().commit();
        ses.close();
    }
    
}
