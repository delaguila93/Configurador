/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.io.Serializable;

/**
 *
 * @author delag
 */
public class Producto implements Serializable {


    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidad;

    public Producto() {
        id = 0;
        nombre = " ";
        precio = 0.0;
        cantidad = 0;
        categoria = " ";
    }

    public Producto(int _id, String _nom, double _prec, String _cat, int _cant) {
        this.id = _id;
        this.nombre = _nom;
        this.precio = _prec;
        this.categoria = _cat;
        this.cantidad = _cant;
    }

    public Producto(Producto p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.precio = p.precio;
        this.categoria = p.categoria;
        this.cantidad = p.cantidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
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

}
