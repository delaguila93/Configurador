/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica.jdbc;

import com.tiendainformatica.dao.ClienteDAO;
import com.tiendainformatica.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author delag
 */
public class ClienteDAOJdbc implements ClienteDAO {

    private DataSource ds = null;

    public ClienteDAOJdbc() {
        Context context;
        try{
            context = new InitialContext(); //Accedemos al contenedor de Servlets
            ds = (DataSource) context.lookup("java:comp/env/jdbc/TiendaInformatica"); //Localizamos el pool
        }catch(NamingException ex){
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean comprobarCorreo(String _corr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscaId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**@brief funcion para mostrar a todos los clientes
     * 
     * @return 
     */
    @Override
    public List<Cliente> buscaTodos() {
        String SQL_BUSCATODOS="Select * from Cliente";
         List<Cliente> cliente=new ArrayList<Cliente>();
         try (
            Connection conn=ds.getConnection(); //Obtenemos conexión del pool de conexiones
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(SQL_BUSCATODOS);
           ){
             while (rs.next()) {
                 cliente.add(clienteMapper(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    /**
     * @brief Funcion para crear un cliente
     * @param c
     * @return 
     */
    @Override
    public boolean crea(Cliente c) {
        String SQL_INSERT="insert into Cliente (correo, nombre, apellidos) values(?,?,?)";
        boolean creado = false;
        try (Connection conn=ds.getConnection();
             PreparedStatement stmn=conn.prepareStatement(SQL_INSERT)) {

            stmn.setString(1, c.getCorreo());
            stmn.setString(2, c.getNombre());
            stmn.setString(3, c.getApellidos());
            creado = true;

        } catch (SQLException ex) {
            Logger.getLogger("ClienteDAOJdbc").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)
        return creado;
    }

    @Override
    public boolean guarda(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borra(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    private Cliente clienteMapper(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}