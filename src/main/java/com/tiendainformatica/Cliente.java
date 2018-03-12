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
    private Date fNac;
    
    public Cliente(){
        this.id=0;
        this.correo="";
        this.nombre="";
        this.apellidos="";
        this.fNac=null;
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
    public Date getfNac() {
        return fNac;
    }

    /**
     * @param fNac the fNac to set
     */
    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }
}

