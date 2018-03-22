/**
 * @file    Cliente.java
 * @Author  Jose María del Águila
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.model;

import java.io.Serializable;
import java.util.Date;


public class Cliente implements Serializable {

    private int id;
    private String correo;
    private String nombre;
    private String apellidos;
    private String fNac;

    /**
     * @brief Constructor de Cliente
     */
    public Cliente() {
        this.id = 0;
        this.correo = "";
        this.nombre = "";
        this.apellidos = "";
        this.fNac = "";
    }

    /**
     * Constructor de copia de Cliente
     * @param c 
     */
    public Cliente(Cliente c) {
        this.id = c.id;
        this.correo = c.correo;
        this.nombre = c.nombre;
        this.apellidos = c.apellidos;
        this.fNac = c.fNac;
    }

    /**
     * @brief Constructor parametrizado de Cliente
     * @param _id
     * @param _corr
     * @param _nom
     * @param _apell
     * @param _f 
     */
    public Cliente(int _id, String _corr, String _nom, String _apell, String _f) {
        this.id = _id;
        this.correo = _corr;
        this.nombre = _nom;
        this.apellidos = _apell;
        this.fNac = _f;
    }

    /**
     * @breif Función para obtener el id de Cliente
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @breif Función para cambiar el id de Cliente
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @breif Función para obtener el Correo de Cliente
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @breif Función para cambiar el correo de Cliente
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @breif Función para obtener el nombre de Cliente
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @breif Función para cambiar el nombre de Cliente
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @breif Función para obtener los apellidos de Cliente
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @breif Función para cambiar los apellidos de Cliente
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @breif Función para obtener la fecha de nacimiento de Cliente
     * @return the fNac
     */
    public String getfNac() {
        return fNac;
    }

    /**
     * @breif Función para cambiar la fecha de nacimiento de Cliente
     * @param fNac the fNac to set
     */
    public void setfNac(String fNac) {
        this.fNac = fNac;
    }
}
