/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.webService.timerecord;

import com.mycompany.practicauno.datamodel.entities.Registros;
import java.util.List;

/**
 *
 * @author thepinguin
 */
public class AfegirRegistreResposta {
    
    private String mensaje;
    private List<Registros> lista;
    
    
    public AfegirRegistreResposta(String mensaje, List<Registros> lista) {
        this.mensaje = mensaje;
        this.lista = lista;
    }
}
