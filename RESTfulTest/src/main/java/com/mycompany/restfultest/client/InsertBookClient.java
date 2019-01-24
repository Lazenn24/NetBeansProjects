/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfultest.client;

import com.mycompany.restfultest.datamodel.entities.Book;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
public class InsertBookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/RESTfulTest/rest/book");
        
        Book b = new Book();
        b.setAuthor("Brandon Sanderson");
        b.setTitle("El pozo de la ascensión");
        b.setIsbn("5");
        
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response res = 
                invocationBuilder.post(Entity.entity(b, MediaType.APPLICATION_JSON));
        
        System.out.println(res.getStatus());
    }
    
}
