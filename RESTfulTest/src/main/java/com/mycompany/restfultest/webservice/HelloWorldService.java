/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfultest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author admin | Benjamin Adam Nagy
 */
@Path("/hello")
public class HelloWorldService {
    
    @GET
    @Produces("text/html")
    public String sayHello() {
        return "Hola Mundo";
    }
}
