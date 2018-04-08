/**
 * @file    ProductoDAOList.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.jdbc;

import com.tiendainformatica.dao.ProductoDAO;
import com.tiendainformatica.model.Producto;
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


public class ProductoDAOJdbc implements ProductoDAO {

    private static final String[] autoField = {"idProducto"}; //Autogenerated field for new records            
    private static final String SQL_BUSCAID = "SELECT * FROM Producto where idProducto=?";

    private static final String connPoolName = "java:comp/env/jdbc/tiendainformatica";
    private static final String SQL_BUSCATODOS = "SELECT * FROM Producto";
    private static final String SQL_BUSCACATEGORIA = "SELECT * FROM Producto WHERE categoria=?";
    private static final String SQL_CREA = "INSERT INTO Producto (nombre,descripcion,precio, categoria) VALUES (?,?,?,?)";
    private static final String SQL_ACTUALIZA = "UPDATE Producto set NOMBRE=?, DESCRIPCION=?, PRECIO=?, CAEGORIA=? WHERE id=?";
    private static final String SQL_BORRA = "DELETE FROM Producto WHERE id=?";
    private DataSource ds = null;

    /**
     * @brief Constructor de ProductoDAOJdbc
     */
    public ProductoDAOJdbc() {
        if (ds == null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup(connPoolName);
            } catch (NamingException ex) {
                Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    /**
     * @brief Recupera un mensaje a partir del registro actual del RS(MAPPING)
     * @param rs
     * @return Producto
     * @throws SQLException 
     */
    private Producto productoMapper(ResultSet rs) throws SQLException {
        Producto p;
        p = new Producto(rs.getInt("idProducto"),
                rs.getString("NOMBRE"),
                rs.getString("DESCRIPCION"),
                rs.getDouble("PRECIO"),
                rs.getString("CATEGORIA")
        );
        return p;
    }

    /**
     * @brief Devuleve los productos que pertenecen a una categoria determinada
     * @param categoria
     * @return Una lista de productos con la categoria igual a la pasada como parámetro
     */
    @Override
    public List<Producto> buscaCategoria(String categoria) {
        List<Producto> lista = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCACATEGORIA)) {
            stmn.setString(1, categoria);
            try (ResultSet rs = stmn.executeQuery()) {
                while (rs.next()) {
                    lista.add(productoMapper(rs));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lista;
    }

    /**
     * @brief Función que devuelve un producto según el id introducido
     * @param id
     * @return Un producto con el id igual al pasado como parámetro
     */
    @Override
    public Producto buscaId(Integer id) {
        Producto p = null;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCAID)) {
            stmn.setInt(1, id);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                p = productoMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }

    /**
     * @brief Funcion que devuelve una lista con todos los productos que hay en la base de datos
     * @return Una lista con todos los Productos
     */
    @Override
    public List<Producto> buscaTodos() {
        List<Producto> lista = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                Statement stmn = conn.createStatement();
                ResultSet rs = stmn.executeQuery(SQL_BUSCATODOS);) {
            while (rs.next()) {
                lista.add(productoMapper(rs));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lista;
    }

    /**
     * @brief Función para crear un producto nuevo
     * @param p
     * @return boolean: true si el producto se ha creado correactamente
     */
    @Override
    public boolean crea(Producto p) {
        boolean result = false;
        try (Connection conn = ds.getConnection();
            PreparedStatement stmn = conn.prepareStatement(SQL_CREA, autoField);) {
                stmn.setString(1, p.getNombre());
                stmn.setString(2, p.getDescripcion());
                stmn.setDouble(3, p.getPrecio());
                stmn.setString(4, p.getCategoria());
                stmn.executeUpdate();
                try (ResultSet rs = stmn.getGeneratedKeys()) {
                    //Get autogenerated field value
                    if (rs != null && rs.next()) {
                        int nuevoId = rs.getInt(1); //RS has only one field with key value
                        p.setId(nuevoId);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }catch (Exception ex) {
                Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        return result;
    }

    /**
     * @brief Función para actualizar un producto en la base de datos
     * @param c
     * @return boolean si el producto no se ha actualizado correcatmente
     */
    @Override
    public boolean guarda(Producto p) {
        String SQL_ACTUALIZA_PRODUCTO = "UPDATE producto SET normbre=?, descripcion=?, precio=?, categoria=? WHERE ipProducto=?";
        boolean actualizado = false;
        try (Connection conn = ds.getConnection(); PreparedStatement stmn = conn.prepareStatement(SQL_ACTUALIZA_PRODUCTO);) {
            stmn.setString(1, p.getNombre());
            stmn.setString(2, p.getDescripcion());
            stmn.setDouble(3, p.getPrecio());
            stmn.setString(4, p.getCategoria());
            if (stmn.executeUpdate() == 1) {
                actualizado = true;
            }
        }catch (Exception ex) {
            Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return actualizado;
    }

    /**
     * @brief Función para borrar un producto de la base de datos
     * @param id
     * @return boolean: true si el producto se ha borrado correctamente
     */
    @Override
    public boolean borra(Integer id) {
        String SQL_BORRA_PRODUCTO = "DELETE FROM Producto WHERE idProducto=?";
        boolean borrado = false;
            try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BORRA_PRODUCTO);) {
                    stmn.setInt(1, id);
                    borrado = (stmn.executeUpdate() == 1);
            }catch (Exception ex) {
                Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        return borrado;    
    }

}
