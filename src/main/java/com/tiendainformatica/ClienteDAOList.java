/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delag
 */
public class ClienteDAOList implements ClienteDAO {

    private List<Cliente> clientes;
    private static int idCliente = 1;
    
    public ClienteDAOList(){
        if(clientes==null){
            clientes=new ArrayList<>();
            clientes.add(new Cliente(idCliente++,"facundo@psoe.na","Facundo","Perez","2012-12-12"));
        }
    }

    @Override
    public Cliente buscaId(Integer id) {
        Cliente encontrado = null;
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                encontrado = c;
            }
        }
        return encontrado;
    }

    @Override
    public List<Cliente> buscaTodos() {
        return clientes;
    }

    @Override
    public boolean crea(Cliente c) {
        Cliente nuevoCliente = new Cliente(c);
        nuevoCliente.setId(idCliente);
        clientes.add(nuevoCliente);
        c.setId(idCliente);
        idCliente++;
        return true;
    }

    @Override
    public boolean guarda(Cliente c) {
        boolean guardado = false;
        Cliente nuevoCliente = new Cliente(c);
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == nuevoCliente.getId()) {
                clientes.set(i, nuevoCliente);
                guardado = true;
            }
        }
        return guardado;
    }

    @Override
    public boolean borra(Integer id) {
        boolean result=false;
        for (int i=0; i<clientes.size();i++) {
            if (clientes.get(i).getId()==id) {
                clientes.remove(i);
                result=true;
            }
        }
        return result;
    }

}
