/**
 * @file    Pedido.java
 * @Author Jose María del Águila López
 * @Author Rafael Galán Ruiz
 */
package com.tiendainformatica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {



    private int id;
    private int idProducto;
    private int idCliente;
    private String estado;
    private double precioTotal;
    private String fecha;
    private int cantidad;

    /**
     * @brief Constructor de Pedido
     */
    public Pedido() {
        id = 0;
        idCliente = 0;
        idProducto = 0;
        estado = "";
        precioTotal = 0;
        fecha = "";
        cantidad=0;
    }
    
    public Pedido(int _id,int _idPr,int _idC,String _est,double _precio,String _fec,int _can){
        this.id=_id;
        this.idProducto=_idPr;
        this.idCliente=_idC;
        this.estado=_est;
        this.precioTotal=_precio;
        this.fecha=_fec;
        this.cantidad=_can;
        
    }
    

    /**
     * @brief Función para obtener el id de un pedido
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @brief Función para obtener el id de un pedido
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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

}
