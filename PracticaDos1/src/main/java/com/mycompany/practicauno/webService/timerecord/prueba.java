/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.webService.timerecord;

import com.mycompany.practicauno.datamodel.entities.Usuario;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author thepinguin
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/PracticaDos1/webservice/caput");
        AfegirRegistrePeticio us = new AfegirRegistrePeticio("caput", "{6Qtf1-rS[HvdtT@6-x]");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.post(Entity.entity(us, MediaType.APPLICATION_JSON));

        System.out.print(res.getStatus());
    }

}
