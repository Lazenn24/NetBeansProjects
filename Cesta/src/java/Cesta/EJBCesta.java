/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cesta;

import javax.ejb.Stateful;

/**
 *
 * @author admin
 */
@Stateful
public class EJBCesta implements EJBCestaLocal {

        private String idTrabajador;

    /**
     * Get the value of idTrabajador
     *
     * @return the value of idTrabajador
     */
    @Override
    public String getIdTrabajador() {
        return idTrabajador;
    }

    /**
     * Set the value of idTrabajador
     *
     * @param idTrabajador new value of idTrabajador
     */
    @Override
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    private String producto;

    /**
     * Get the value of producto
     *
     * @return the value of producto
     */
    @Override
    public String getProducto() {
        return producto;
    }

    /**
     * Set the value of producto
     *
     * @param producto new value of producto
     */
        @Override
    public void setProducto(String producto) {
        this.producto = producto;
    }

    private String cantidad;

    /**
     * Get the value of cantidad
     *
     * @return the value of cantidad
     */
        @Override
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Set the value of cantidad
     *
     * @param cantidad new value of cantidad
     */
        @Override
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


    
}
