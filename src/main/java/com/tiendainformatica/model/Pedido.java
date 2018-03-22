/**
 * @file    Pedido.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Pedido implements Serializable {

    private int id;
    private List<Producto> lista;
    private final int totalProductos;

    /**
     * @brief Constructor de Pedido
     */
    public Pedido() {
        id = 0;
        lista = new ArrayList<>();
        totalProductos = 0;
    }
    
    /**
     * @brief Función para obtener el id de un pedido
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @brief Función para obtener el id de un pedido
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @brief Función para obtener la lista de productos del pedido
     * @return La lista de productos
     */
    public List<Producto> getLista() {
        return lista;
    }

    /**
     * @brief Función para modificar los productos de pedido
     * @param lista the lista to set
     */
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    
    
    /**
     * 
     * @return 
     */
    int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
