/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.util.List;

public interface GenericDAO<T,K> {
    
    public T buscaId(K id);
    public List<T> buscaTodos();
    public boolean crea(T c);
    public boolean guarda(T c);    
    public boolean borra(K id);
}