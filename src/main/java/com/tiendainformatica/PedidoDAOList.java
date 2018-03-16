/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.util.List;

/**
 *
 * @author delag
 */
public class PedidoDAOList implements PedidoDAO {

    private Pedido pedido=null;
    
    public PedidoDAOList(){
        pedido=new Pedido();
    }
    
    @Override
    public boolean anadeProducto(Producto p) {
        
        return true;
    }

    @Override
    public boolean eliminaProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculaTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
