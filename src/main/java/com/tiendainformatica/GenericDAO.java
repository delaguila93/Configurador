/**
 * @file    GenericDAO.java
 * @Author  Jose María del Águila Lóopez
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica;

import java.util.List;

public interface GenericDAO<T,K> {
    
    /**
     * @brief Busqueda por id
     * @param id
     * @return T
     */
    public T buscaId(K id);
    
    /**
     * @brief Muestra todos los Elemento<T>
     * @return Lista T
     */
    public List<T> buscaTodos();
    
    /**
     * @brief Crear un Elemento<T>
     * @param c
     * @return boolean
     */
    public boolean crea(T c);
    
    /**
     * @brief Guardar un Elemento<T>
     * @param c
     * @return boolean
     */
    public boolean guarda(T c);  
    
    /**
     * @brief Borrar un Elemento<T>
     * @param id
     * @return boolean
     */
    public boolean borra(K id);
}