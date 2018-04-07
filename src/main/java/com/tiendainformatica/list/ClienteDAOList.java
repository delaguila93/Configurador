/**
 * @file    ClienteDAOList.java
 * @Author Jose María del Águila
 * @Author Rafael Galán Ruiz
 */
package com.tiendainformatica.list;

import com.tiendainformatica.dao.ClienteDAO;
import com.tiendainformatica.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOList implements ClienteDAO {

    private List<Cliente> clientes;
    private static int idCliente = 1;

    /**
     * @brief Constructor de ClienteDAOList Los clientes contienen: idCliente
     * Correo Nombre Apellidos Fecha de Nacimiento
     */
    public ClienteDAOList() {
        if (clientes == null) {
            clientes = new ArrayList<>();
            /*clientes.add(new Cliente(idCliente++,"facundo@psoe.na","Facundo","Perez","2012-12-12"));
            clientes.add(new Cliente(idCliente++,"kkkkkk@jjjj.na","ggggg","tttttt","2052-11-09"));*/
        }
    }

    /**
     * @brief Función para coprobar el correo de un cliente
     * @param _corr
     * @return true si el correo se ha introducido correctamente
     */
    @Override
    public boolean comprobarCorreo(String _corr) {
        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getCorreo() == null ? _corr == null : c.getCorreo().equals(_corr)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    /**
     * @brief Funcion que busca un cliente por su id
     * @param id
     * @return el cliente que coincida con el id introducido
     */
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

    /**
     * @brief Funcion que devuelve todos los cliente que hay en la plataforma
     * @return Una lista con todos los cliente de la plataforma
     */
    @Override
    public List<Cliente> buscaTodos() {
        return clientes;
    }

    /**
     * @brief Función para crear un cliente
     * @param c
     * @return true cuando el cliente se haya creado
     */
    @Override
    public boolean crea(Cliente c) {
        Cliente nuevoCliente = new Cliente(c);
        nuevoCliente.setId(idCliente);
        clientes.add(nuevoCliente);
        c.setId(idCliente);
        idCliente++;
        return true;
    }

    /**
     * @brief Función para guardar un cliente
     * @param c
     * @return True si el cliente se ha guardado correcatamente
     */
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

    /**
     * @brief Función para borrar un cliente
     * @param id
     * @return True si el cliente se ha borrado correctamente
     */
    @Override
    public boolean borra(Integer id) {

        boolean result = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Cliente buscarCorreo(String _corr) {
        Cliente encontrado = null;
        for (Cliente c : clientes) {
            if (c.getCorreo() == _corr) {
                encontrado = c;
            }
        }
        return encontrado;
    }

}
