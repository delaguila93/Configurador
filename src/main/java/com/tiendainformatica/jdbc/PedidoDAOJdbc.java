/**
 * @file    PedidoDAO.java
 * @Author  Jose María del Águila
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica.jdbc;

import com.tiendainformatica.dao.PedidoDAO;
import com.tiendainformatica.dao.ProductoDAO;
import com.tiendainformatica.model.Cliente;
import com.tiendainformatica.model.Pedido;
import com.tiendainformatica.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PedidoDAOJdbc implements PedidoDAO {
    
    private static final String[] autoField = {"idProducto"}; //Autogenerated field for new records    
    private static final String connPoolName = "java:comp/env/jdbc/tiendainformatica"; ///Tomcat
    private DataSource ds = null; ///referencia al pool de conexiones
    
    private static final String SQL_ANADEPRODUCTO = "INSERT INTO Pedido(idCliente,idProducto,estado,precioTotal,fecha,cantidad) VALUES(?,?,?,?,?,?)";
    private static final String SQL_CAMBIAESTADO = "UPDATE Pedido set ESTADO=? WHERE idCliente=?";
    private static final String SQL_BUSCAPRODUCTOS = "SELECT p.idPedido,p.idProducto,p.idCliente,p.estado,p.precioTotal,p.fecha,p.cantidad FROM pedido p,Producto pr,Cliente c WHERE p.idProducto=pr.idProducto AND p.idCliente=? AND p.idCliente=c.idCliente";
    
    /**
     * brief Constructor de PedidoDAOJdbc
     */
    public PedidoDAOJdbc() {
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
     * @return Pedido
     * @throws SQLException 
     */
    private Pedido pedidoMapper(ResultSet rs) throws SQLException {
        Pedido c;
        c = new Pedido(rs.getInt("idCliente"),
                rs.getInt("idProducto"),
                rs.getInt("idCliente"),
                rs.getString("ESTADO"),
                rs.getDouble("PRECIOTOTAL"),
                rs.getString("FECHA"),
                rs.getInt("CANTIDAD")
        );
        return c;
    }
    /**
     * @brief Función para crear un nuevo pedido
     * @param p
     * @param _idC
     * @param cantidad
     * @return Pedido
     */
    @Override
    public boolean creaPedido(Producto p, int _idC, int cantidad) {
        boolean result = false;
        String patron = "dd-MM-yyyy";
        String fecha =new SimpleDateFormat(patron).format(new Date());
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_ANADEPRODUCTO, autoField);) {
            stmn.setInt(1, p.getId());
            stmn.setInt(2, _idC);
            stmn.setString(3, "Preparando");
            stmn.setDouble(4, p.getPrecio());
            stmn.setString(5, fecha);
            stmn.setInt(6, cantidad);
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
        } catch (Exception ex) {
            Logger.getLogger(ProductoDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
        
    }
    /**
     * @brief funcion para calcular el precio total de un pedido (No implementada aún)
     * @param p
     * @return docuble con el precio total de un pedido
     */
    @Override
    public double calculaTotal(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @brief Función para cambiar el estado de un pedido 
     * @param id
     * @return boolean: True si el cambio de estado del pedio se ha realizado correctamente
     */
    @Override
    public boolean cambiarEstado(int id) {
        boolean result = false;
        try (Connection conn = ds.getConnection(); PreparedStatement stmn = conn.prepareStatement(SQL_CAMBIAESTADO);) {
            stmn.setString(1, "Enviado");
            stmn.setInt(2, id);
            if (stmn.executeUpdate() == 1) {
                result = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }
    /**
     * @breif funcion que devuele los pedido realizados
     * @param idC
     * @return Una lista con los pedidos realizados
     */
    @Override
    public List<Pedido> listaProductos(int idC) {
        List<Pedido> l = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCAPRODUCTOS);) {
            stmn.setInt(1, idC);
            ResultSet rs = stmn.executeQuery();           
            while (rs.next()) {
                l.add(pedidoMapper(rs));
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAOJdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;
    }
    
}
