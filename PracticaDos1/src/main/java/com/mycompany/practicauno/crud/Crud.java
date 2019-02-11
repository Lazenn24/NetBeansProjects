/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.crud;


import com.mycompany.practicauno.datamodel.HibernateUtil;
import com.mycompany.practicauno.datamodel.entities.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
/**
 *
 * @author thepinguin
 */
public class Crud {
    
   
    public void insertUser(String name, String pass, String email){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        
        Usuario user = new Usuario();
        
        user.setNombre(name);
        user.setContrasenya(getMD5(pass));
        user.setEmail(email);
        
        session.save(user);
        
        session.getTransaction().commit();
        
        
        session.close();
        
    }
    
    public Usuario okUser(String name, String pass){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        String hql = "FROM Usuario WHERE nombre = '" + name + "' and contrasenya = '" + getMD5(pass) + "'";
        //String hql = "select r FROM Usuario u, Registros r WHERE nombre = 'caput' and contrasenya = '"+ getMD5("{6Qtf1-rS[HvdtT@6-x]")+"'";
        Query query = session.createQuery(hql);
        List<Usuario> usuarios = query.list();
        
        if(usuarios.isEmpty()){
            session.getTransaction().commit();
            session.close();
            return null;
        }else{
             
            session.getTransaction().commit();
            session.close();
            return usuarios.get(0);
        }
        
        
    }
    
    public  void newES(Date fecha, String tipo, Usuario us ){
        
        
        
        if(ultima(us) && tipo.equals("salida")){
            
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Registros re = new Registros();

            re.setFecha(fecha);
            re.setTipo(tipo);
            re.setIdUs(us);

            session.save(re);

            session.getTransaction().commit();
            session.close();
        
        }else if(ultima(us) == Boolean.FALSE && tipo.equals("entrada")){
                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Registros re = new Registros();

            re.setFecha(fecha);
            re.setTipo(tipo);
            re.setIdUs(us);

            session.save(re);

            session.getTransaction().commit();
            session.close();
        }
        
        
            
        
        
        
    }
    
    public List<Registros> allReg(Usuario us){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        
        
        String hql = "FROM Registros WHERE idUs ='" + us.getId() + "'";
        Query query = session.createQuery(hql);
        List<Registros> usuarios = query.list();
        
        if(usuarios.isEmpty()){
            
            session.close();
            return null;
        }else{
             
            
            session.close();
            return usuarios;
        
        }
    }
    
    public boolean ultima(Usuario us){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        String hql2 = "FROM Registros WHERE idUs ='" + us.getId() + "' order by idUs DESC";
               Query query2 = session.createQuery(hql2);
              
               List<Registros> registros = query2.list();
               
               String salidaEntrada = "";
               for(Registros registro : registros){
                  salidaEntrada = registro.getTipo();
               }
               
               
               if(salidaEntrada.equals("salida") || salidaEntrada.equals("")){
                 return false;
               }else{
                return true;
               }
    }
    
    public static String getMD5(String input) {
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
        }
        return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
        }
 }
    

}
