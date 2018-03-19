/**
 * @file    ProductoDAO.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica;

import java.util.List;


public interface ProductoDAO extends GenericDAO<Producto, Integer> {
    
    /**
     * @brief función que devuelve los productos según la categoria dada
     * @param categoria
     * @return devuelve una lista de productos con la categoria en común
     */
    public List<Producto> buscaCategoria(String categoria);
   
}
