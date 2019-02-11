/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.webService;

import com.mycompany.practicauno.webService.timerecord.AfegirRegistrePeticio;
import com.mycompany.practicauno.webService.timerecord.AfegirRegistreResposta;
import static com.mycompany.practicauno.crud.Crud.getMD5;
import com.mycompany.practicauno.datamodel.HibernateUtil;
import com.mycompany.practicauno.datamodel.entities.*;
import java.util.List;
import org.hibernate.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author thepinguin
 */
@Path("/caput")
public class RegisService {


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AfegirRegistreResposta getRegistros(AfegirRegistrePeticio peticio){
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        
        String hql = "FROM Usuario u WHERE u.nombre = '" + peticio.getUsername() + "' and u.contrasenya = '" + getMD5(peticio.getPassword()) + "'";
        Query query =  ses.createQuery(hql);
        
        String ok = "OK";
        if(query.list().isEmpty()){
            
            ses.close();
            return null;

        }else{
            List<Usuario> user = query.list();
            
            int id = user.get(0).getId();
            String hqla = "FROM Registros r WHERE r.idUs = '" + id + "'";
            Query querys =  ses.createQuery(hqla);
            List<Registros> regs = querys.list();
            
            
            AfegirRegistreResposta neww = new AfegirRegistreResposta(ok, regs);
            ses.close();
            return neww;

        }
    }
 //   @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void create(String usuario, String password, String entradaOSalida ){
//            SessionFactory sf = HibernateUtil.getSessionFactory();
//            Session ses = sf.openSession();
//            
//             
//    //    String hql = "SELECT Registros.fecha, Registros.SalidaOEntrada FROM Registros,Usuario WHERE nombre='" + usuario + "' and password='" + getMD5(password) + "'";
////        Query query =  ses.createQuery(hql);
////        List<Registros> registros = query.list();
////        
////        if(registros.isEmpty()){
////            out.println("Error");
////            ses.close();
////
////        }else{
////            Usuario idUsuario = registros.get(0).getIdUsuario();
////            Registros registro = new Registros();
////            Date fecha = new Date();
////
////            registro.setFecha(fecha);
////            registro.setSalidaOEntrada(entradaOSalida);
////            registro.setIdUsuario(idUsuario);
////            
////            out.println("OK");
//            ses.close();
//
//     //   }
//    }
    
}
