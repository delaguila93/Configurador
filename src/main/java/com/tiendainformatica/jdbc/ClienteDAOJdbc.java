/**
 * @file    ClienteDAOList.java
 * @Author Jose María del Águila
 * @Author Rafael Galán Ruiz
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


public class ClienteDAOJdbc implements ClienteDAO {

    private static final String dbTable = "Cliente";
    private static final String[] autoField = {"id"}; //Autogenerated field for new records
    private static final String connPoolName = "java:comp/env/jdbc/tiendainformatica";  //Tomcat

    private static final String SQL_BUSCAID = "SELECT * FROM Cliente where idCliente=?";
    private static final String SQL_BUSCATODOS = "SELECT * FROM Cliente";
    private static final String SQL_CREA = "INSERT INTO Cliente (correo,clave,nombre,apellidos, fnac) VALUES (?,?,?,?,?)";
    private static final String SQL_ACTUALIZA = "UPDATE Cliente set CORREO=?, NOMBRE=?, APELLIDOS=?, FNAC=? WHERE idCliente=?";
    private static final String SQL_BORRA = "DELETE FROM Cliente WHERE idCliente=?";
    private static final String SQL_CORREO = "SELECT * FROM Cliente WHERE correo=?";
    private static final String SQL_CREAROL = "INSERT INTO Roles (correo,rol) VALUES (?,?)";
    private static final String SQL_BUSCACORREO = "SELECT * FROM Cliente where correo=?";

    private DataSource ds = null; ///referencia al pool de conexciones
    
    /**
     * @brief Constructor de ClienteDAOJdbc
     */
    public ClienteDAOJdbc() {
        if (ds == null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup(connPoolName);
            } catch (NamingException ex) {
                Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    /**
     * @brief Recupera un mensaje a partir del registro actual del RS(MAPPING)
     * @param rs
     * @return Cliente
     * @throws SQLException 
     */
    private Cliente clienteMapper(ResultSet rs) throws SQLException {
        Cliente c;
        c = new Cliente(rs.getInt("idCliente"),
                rs.getString("CORREO"),
                rs.getString("CLAVE"),
                rs.getString("NOMBRE"),
                rs.getString("APELLIDOS"),
                rs.getString("FNAC")
        );
        return c;
    }
    
    /**
     * @brief Función para comprobar si un correro es correcto
     * @param _corr
     * @return boolean: True si el correo es correcto. False en caso contrario
     */
    @Override
    public boolean comprobarCorreo(String _corr) {
        boolean encontrado = false;
        Cliente c = null;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_CORREO)) {
            stmn.setString(1, _corr);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                c = clienteMapper(rs);
                if (c.getCorreo() == null ? _corr == null : c.getCorreo().equals(_corr)) {
                    encontrado = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return encontrado;
    }
    
    /**
     * @brief Fución que devuelve un Cliente según el id introducido
     * @param id
     * @return Cliente con el id igual al id que se pasa por parámetro
     */
    @Override
    public Cliente buscaId(Integer id) {
        Cliente c = null;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCAID)) {
            stmn.setInt(1, id);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                c = clienteMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return c;
    }
    /**
     * @brief Función que devuelve todos los clientes que hay en la base de datos
     * @return Todos los Cliente que hay en ese momento en la base de datos
     */
    @Override
    public List<Cliente> buscaTodos() {
        List<Cliente> l = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                Statement stmn = conn.createStatement();
                ResultSet rs = stmn.executeQuery(SQL_BUSCATODOS);) {
            while (rs.next()) {
                l.add(clienteMapper(rs));
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;
    }
    
    /**
     * @brief Función que asigna un rol a los usuarios de la base de datos
     * @param correo
     * @return Tre si el rol ha sido asignado correctamente
     */
    private boolean creaRol(String correo) {
        boolean result = false;
        String rol = "USUARIO";
        try (Connection conn = ds.getConnection(); PreparedStatement stmn = conn.prepareStatement(SQL_CREAROL);) {
            stmn.setString(1, correo);
            stmn.setString(2, rol);
            stmn.executeUpdate();
            try (ResultSet rs = stmn.getGeneratedKeys()) {
                if (rs != null && rs.next()) {
                    result = true;
                }
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }
    /**
     * @brief Función para crear un cliente nuevo
     * @param c
     * @return boolean: True si el cliente se ha creado correctamente
     */
    @Override
    public boolean crea(Cliente c) {
        boolean result = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_CREA, autoField);) {
            stmn.setString(1, c.getCorreo());
            stmn.setString(2, c.getClave());
            stmn.setString(3, c.getNombre());
            stmn.setString(4, c.getApellidos());
            stmn.setString(5, c.getfNac());
            stmn.executeUpdate();
            try (ResultSet rs = stmn.getGeneratedKeys()) {
                //Get autogenerated field value
                if (rs != null && rs.next()) {
                    int nuevoId = rs.getInt(1); //RS has only one field with key value
                    c.setId(nuevoId);
                    creaRol(c.getCorreo());
                    result = true;
                }
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }
    /**
     * @brief Función para actualizar un cliente en la base de datos
     * @param c
     * @return boolean si el cliente a sido actualizado correctamente
     */
    @Override
    public boolean guarda(Cliente c) {
        boolean result = false;
        try (Connection conn = ds.getConnection(); PreparedStatement stmn = conn.prepareStatement(SQL_ACTUALIZA);) {

            stmn.setString(1, c.getCorreo());
            stmn.setString(2, c.getNombre());
            stmn.setString(3, c.getApellidos());
            stmn.setString(4, c.getfNac());
            stmn.setInt(5, c.getId());
            if (stmn.executeUpdate() == 1) {
                result = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }

    /**
     * @brief Función para borrar un cliente de la base de datos
     * @param id
     * @return boolean: True si se ha borrado correctamente al cliente
     */
    @Override
    public boolean borra(Integer id) {
        boolean result = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BORRA);) {
            stmn.setInt(1, id);
            result = (stmn.executeUpdate() == 1);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }

    /**
     * @brief Función que devuelve un cliente según el correo introducido
     * @param _corr
     * @return Cliente con el correo igual al que se pasa por parámetro
     */
    @Override
    public Cliente buscarCorreo(String _corr) {
        Cliente c = null;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCACORREO)) {
            stmn.setString(1, _corr);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                c = clienteMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return c;
    }

}
