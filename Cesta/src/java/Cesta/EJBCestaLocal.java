/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cesta;

import javax.ejb.Local;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Local
public interface EJBCestaLocal {
    
    @Digits(integer = 4, fraction = 0)
    @Size(min = 1, max = 9999)
    public String getIdTrabajador();

    public void setIdTrabajador(String idTrabajador);
        
    @NotNull
    public String getProducto();
    
    public void setProducto(String producto);
    
    @Unitats
    public String getCantidad();
    
    public void setCantidad(String cantidad);
    
}
