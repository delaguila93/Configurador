/**
 * @file    Producto.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica;

import java.io.Serializable;


public class Producto implements Serializable {


    private int id;
    private String nombre;
    private String imagen;
    private String descripcion;
    private double precio;
    private String categoria;

    /**
     * @brief Constructor de Producto
     */
    public Producto() {
        id = 0;
        nombre = " ";
        imagen = " ";
        descripcion = " ";
        precio = 0.0;
        categoria = " ";
    }

    /**
     * @brief Constructor parametrizado de Producto
     */
    public Producto(int _id, String _nom, String _img, String _des, double _prec, String _cat) {
        this.id = _id;
        this.nombre = _nom;
        this.imagen = _img;
        this.descripcion = _des;
        this.precio = _prec;
        this.categoria = _cat;
    }

    /**
     * @brief Constructor Copia de Producto
     */
    public Producto(Producto p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.imagen = p.imagen;
        this.descripcion = p.descripcion;
        this.precio = p.precio;
        this.categoria = p.categoria;
    }

    /**
     * @brief Función para obtener el nombre de un producto
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @brief Función para cambiar el nombre de un producto
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @brief Función para obtener una imagen
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @brief Función para cambiar una imagen
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * @brief Función para obtener la descripción de un producto
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @brief Función para canbiar la descripción de un producto
     * @param descripcion the descripcion to set
     */
    public void set(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * @brief Función para obtener el precio de un producto
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @brief Función para cambiar el precio de un producto
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @brief Función para obtener la categoría de un producto
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @brief Función para cambiar la categoría de un producto
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @brief Función para obtener el id de un producto
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @brief Función para cambiar el id de un producto
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
