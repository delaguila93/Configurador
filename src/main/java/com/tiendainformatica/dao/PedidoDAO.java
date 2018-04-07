/**
 * @file    PedidoDAO.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.dao;

import com.tiendainformatica.model.Cliente;
import com.tiendainformatica.model.Pedido;
import com.tiendainformatica.model.Producto;
import java.util.*;


public interface PedidoDAO  {
    
    /**
     * @brief Función para añadir un producto al pedido
     * @param p
     * @return true si el producto se ha añadidio
     */
    public boolean creaPedido(Producto p,int _idC,int cantidad);
    

    
    /**
     * @brief Función para calcular el total de un pedido
     * @param p
     * @return el total de pedido
     */
    public List<Pedido> listaProductos(int idC);
    
    public double calculaTotal(Producto p);
    
    public boolean cambiarEstado(int id);
}
