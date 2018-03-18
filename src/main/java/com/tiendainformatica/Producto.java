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
    private String imagen;
    private String descripcion;
    private double precio;
    private String categoria;

    public Producto() {
        id = 0;
        nombre = " ";
        imagen = " ";
        descripcion = " ";
        precio = 0.0;
        categoria = " ";
    }

    public Producto(int _id, String _nom, String _img, String _des, double _prec, String _cat) {
        this.id = _id;
        this.nombre = _nom;
        this.imagen = _img;
        this.descripcion = _des;
        this.precio = _prec;
        this.categoria = _cat;
    }

    public Producto(Producto p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.imagen = p.imagen;
        this.descripcion = p.descripcion;
        this.precio = p.precio;
        this.categoria = p.categoria;
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
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void set(String descripcion) {
        this.descripcion = descripcion;
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
