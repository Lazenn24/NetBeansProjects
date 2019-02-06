/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.webservice.client;

import com.mycompany.practicafinal.webservice.pojo.GetAllRequest;
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
public class ClientePrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/PracticaFinal/webservice/schedule");

        GetAllRequest request = new GetAllRequest();
        request.setUser("Antonio");
        request.setPassword("@Antonio3");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response res
                = invocationBuilder.post(Entity.entity(request, MediaType.APPLICATION_JSON));
        
        
        System.out.println(res.getStatus());

    }

}
