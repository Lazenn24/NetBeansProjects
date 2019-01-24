package com.mycompany.testhibernate;


import com.mycompany.testhibernate.Entities.Author;
import com.mycompany.testhibernate.Entities.Book;
import com.mycompany.testhibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class TestBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // CRUD Create Read Update Delete
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        // Insert
        
//        Author autor2 = new Author();
//        autor2.setName("Autor2");
//        session.save(autor2);
//        
//        Book libro1 = new Book();
//        libro1.setName("libro1");
//        libro1.setAuthor(autor2);
//        session.save(libro1);


        // Query
        
//        String hql = "FROM Author a where a.id = '2'";
//        Query query = session.createQuery(hql);
//        List<Author> autores = query.list();
//        
//        for(Author a: autores){
//            System.out.println(a.getId() + a.getName());
//        }
//        Author segundoAutor = autores.get(0);
//        
        // UPDATE
//        segundoAutor.setName("Autor actualizado");
//        session.update(segundoAutor);

        // Query con join
//        String hqlLibrosConAutor = "select b from Author as a inner join a.books as b";
//        query = session.createQuery(hqlLibrosConAutor);
//        
//        List<Book> books = query.list();
//        
        // Delete
        
        String hqlAutor1 = "FROM Author AS a where a.id = '1'";
        Query query = session.createQuery(hqlAutor1);
        List<Author> autores = query.list();
        
        Author autor = autores.get(0);
        session.delete(autor);
        
        
        


        
        
        session.getTransaction().commit();
        
        session.close();
    }
    
}
