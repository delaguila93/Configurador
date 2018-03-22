/**
 * @file    PedidoDAO.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.dao;

import com.tiendainformatica.model.Producto;


public interface PedidoDAO  {
    
    /**
     * @brief Función para añadir un producto al pedido
     * @param p
     * @return true si el producto se ha añadidio
     */
    public boolean anadeProducto(Producto p);
    
    /**
     * @brief Función para eliminar un producto del Pedido
     * @param id
     * @return true si el pedidio se ha eliminado
     */
    public boolean eliminaProducto(int id);
    
    /**
     * @brief Función para calcular el total de un pedido
     * @param p
     * @return el total de pedido
     */
    public double calculaTotal(Producto p);
    
}
