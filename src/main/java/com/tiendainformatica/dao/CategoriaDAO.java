/**
 * @file    CategoriaDAO.java
 * @Author  Jose María del Águila
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.dao;

import java.util.ArrayList;
import java.util.List;

/*Sample DAO implementation using an ArrayList of Objects in memory*/
public class CategoriaDAO {

    private final ArrayList<String> categorias;

    public CategoriaDAO() {
        categorias = new ArrayList<>();
        categorias.add("Placa base");
        categorias.add("Procesadores");
        categorias.add("Memoria RAM");
        categorias.add("Gaming");
        categorias.add("Tarjeta Grafica");
    }

    public String buscaId(Integer id) {
        return categorias.get(id);
    }

    
    public List<String> buscaTodos() {
        return categorias;
    }

}
