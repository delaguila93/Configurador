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
public class ProductoDAOList implements ProductoDAO {

    private static ArrayList<Producto> productos = null;
    private static int idProducto = 1;

    public ProductoDAOList() {
        if (productos == null) {

        }
    }

    @Override
    public Producto buscaId(Integer id) {
        Producto encontrado = null;
        for (Producto p : productos) {
            if (p.getId() == id) {
                encontrado = p;
            }
        }
        return encontrado;
    }

    @Override
    public List<Producto> buscaTodos() {
        return productos;
    }

    @Override
    public boolean crea(Producto p) {
        Producto nuevoProducto = new Producto(p);
        nuevoProducto.setId(idProducto);
        productos.add(nuevoProducto);
        p.setId(idProducto);
        idProducto++;
        return true;
    }

    @Override
    public boolean guarda(Producto p) {
        boolean guardado= false;
        Producto nuevoProducto = new Producto(p);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == nuevoProducto.getId()) {
                productos.set(i, nuevoProducto);
                guardado = true;
            }
        }
        return guardado;
    }

    @Override
    public boolean borra(Integer id) {
        boolean borrado = false;
        for (Producto p : productos) {
            if (p.getId() == id) {
                productos.remove(p);
                borrado = true;
            }
        }
        return borrado;
    }

    @Override
    public List<Producto> buscaCategoria(String categoria) {
        List<Producto> listaProd = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                listaProd.add(p);
            }
        }
        return listaProd;
    }

}
