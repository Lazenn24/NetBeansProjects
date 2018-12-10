package Cesta;


import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class UserCompra {

    public UserCompra(String idTrabajador, String producto, String cantidad) {
        this.idTrabajador = idTrabajador;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    
    
        private String idTrabajador;

    /**
     * Get the value of idTrabajador
     *
     * @return the value of idTrabajador
     */
    public String getIdTrabajador() {
        return idTrabajador;
    }

    /**
     * Set the value of idTrabajador
     *
     * @param idTrabajador new value of idTrabajador
     */
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    private String producto;

    /**
     * Get the value of producto
     *
     * @return the value of producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Set the value of producto
     *
     * @param producto new value of producto
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    private String cantidad;

    /**
     * Get the value of cantidad
     *
     * @return the value of cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Set the value of cantidad
     *
     * @param cantidad new value of cantidad
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
}
