/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

/**
 *
 * @author delag
 */
public interface PedidoDAO  {
    
    public boolean anadeProducto(Producto p);
    
    public boolean eliminaProducto(int id);
    
    public double calculaTotal();
    
}
