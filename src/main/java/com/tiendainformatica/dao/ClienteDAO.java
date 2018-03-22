/**
 * @file    ClienteDAO.java
 * @Author  Jose María del Águila
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.dao;

import com.tiendainformatica.model.Cliente;


public interface ClienteDAO extends GenericDAO<Cliente, Integer> {
    
    /**
     * @brief Función para coprobar el correo de un cliente
     * @param _corr
     * @return true si el correo se ha introducido correctamente
     */
    public boolean comprobarCorreo(String _corr);
    
}
