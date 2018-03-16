/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delag
 */
public class Pedido implements Serializable {

    public Pedido() {
        id = 0;
        lista = new ArrayList<>();
    }

    private int id;
    private List<Producto> lista;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lista
     */
    public List<Producto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

}
