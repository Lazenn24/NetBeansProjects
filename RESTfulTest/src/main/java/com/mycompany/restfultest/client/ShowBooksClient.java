/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfultest.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.restfultest.datamodel.entities.Book;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
public class ShowBooksClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/RESTfulTest/rest/book");
        Invocation invocation = target.request().buildGet();
        
        Response respuesta = invocation.invoke();
        
        String booksJson = respuesta.readEntity(String.class);
        System.out.println("Libros en formato JSON: " + booksJson);
        
        Gson gson = new Gson();
        List<Book> books = gson.fromJson(booksJson, 
                new TypeToken<List<Book>>(){}.getType());
        
        for(Book b: books){
            //System.out.println(b.toString());
            System.out.println(b.getIsbn());
            System.out.println(b.getTitle());
            System.out.println(b.getAuthor());
        }
        
    }
    
}
