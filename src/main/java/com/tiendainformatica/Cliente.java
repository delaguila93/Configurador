/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author delag
 */
public class Cliente implements Serializable {

    private int id;
    private String correo;
    private String nombre;
    private String apellidos;
    private String fNac;

    public Cliente() {
        this.id = 0;
        this.correo = "";
        this.nombre = "";
        this.apellidos = "";
        this.fNac = "";
    }

    public Cliente(Cliente c) {
        this.id = c.id;
        this.correo = c.correo;
        this.nombre = c.nombre;
        this.apellidos = c.apellidos;
        this.fNac = c.fNac;
    }

    public Cliente(int _id, String _corr, String _nom, String _apell, String _f) {
        this.id = _id;
        this.correo = _corr;
        this.nombre = _nom;
        this.apellidos = _apell;
        this.fNac = _f;
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

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the fNac
     */
    public String getfNac() {
        return fNac;
    }

    /**
     * @param fNac the fNac to set
     */
    public void setfNac(String fNac) {
        this.fNac = fNac;
    }
}
