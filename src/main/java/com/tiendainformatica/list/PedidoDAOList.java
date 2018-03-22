/**
 * @file    PedidoDAOList.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.list;

import com.tiendainformatica.dao.PedidoDAO;
import com.tiendainformatica.model.Producto;
import com.tiendainformatica.model.Pedido;


public class PedidoDAOList implements PedidoDAO {

    private Pedido pedido=null;
    
    /**
     * @brief Constructor PedidoDAOList
     */
    public PedidoDAOList(){
        pedido=new Pedido();
    }
    
    /**
     * @brief Función para añadir un producto al pedido
     * @param p
     * @return true si el producto se ha añadidio
     */
    @Override
    public boolean anadeProducto(Producto p) {
        
        return true;
    }

    /**
     * @brief Función para eliminar un producto del Pedido
     * @param id
     * @return true si el pedidio se ha eliminado
     */
    @Override
    public boolean eliminaProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @brief Función para eliminar un producto del Pedido
     * @param id
     * @return true si el pedidio se ha eliminado
     */
    @Override
    public double calculaTotal(Producto p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double total = 0;
        total = total + p.getPrecio();
        return total;
    }

    
    
}
