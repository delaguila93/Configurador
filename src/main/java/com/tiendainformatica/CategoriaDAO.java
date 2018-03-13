/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

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
