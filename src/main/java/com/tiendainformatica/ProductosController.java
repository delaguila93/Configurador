/**
 * @file    ProductoController.java
 * @Author Jose María del Águila López
 * @Author Rafael Galán Ruiz
 */
package com.tiendainformatica;

import com.tiendainformatica.list.ProductoDAOList;
import com.tiendainformatica.dao.CategoriaDAO;
import com.tiendainformatica.dao.ProductoDAO;
import com.tiendainformatica.model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.runtime.Log;

/**
 *
 * @author delag
 */
@WebServlet("/productos/*")
public class ProductosController extends HttpServlet {

    private ProductoDAO productoDAO;
    private CategoriaDAO categoriaDAO;
    private final String srvViewPath = "/WEB-INF/productos";
    private String srvUrl;
    private String imgUrl;
    private static final Logger Log = Logger.getLogger(ProductosController.class.getName());

    //Pedidos
    private List<Producto> pedido = null;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);
        srvUrl = servletConfig.getServletContext().getContextPath() + "/productos";
        imgUrl = servletConfig.getServletContext().getContextPath() + "/imagenes";
        productoDAO = new ProductoDAOList();
        categoriaDAO = new CategoriaDAO();

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("srvUrl", srvUrl);
        request.setAttribute("imgUrl", imgUrl);
        request.setAttribute("categorias", categoriaDAO.buscaTodos().toArray());
        request.setAttribute("producto", productoDAO.buscaTodos().toArray());

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

        RequestDispatcher rd = null;

        //Detect current servlet action
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        Log.log(Level.INFO, "Petición GET {0}", action);

        switch (action) {
            //Para visualizar los productos según la categoría
            case "/visualizaCategoria": {
                String categoria = request.getParameter("categoria");
                request.setAttribute("productosCategoria", productoDAO.buscaCategoria(categoria));
                request.setAttribute("categoria", categoria);
                rd = request.getRequestDispatcher(srvViewPath + "/visualizaCategoria.jsp");
                break;

            }
            //Para mostrar todos los productos
            case "/productos": {
                List<Producto> lp;
                lp = productoDAO.buscaTodos();
                request.setAttribute("productoDAO", lp);
                rd = request.getRequestDispatcher(srvViewPath + "/productos.jsp");
                break;
            }
            //Para añadir un producto al pedido
            case "/anadeProducto": {
                Producto p;
                int id = Integer.parseInt(Util.getParam(request.getParameter("id"), "0"));
                p = productoDAO.buscaId(id);
                if (pedido == null) {
                    pedido = new ArrayList<>();
                }
                pedido.add(p);
                rd = request.getRequestDispatcher(srvViewPath + "/productos.jsp");
                break;
            }
            //Para mostrar el pedido en la cesta
            case "/cesta": {
                request.setAttribute("pedido", pedido);
                rd = request.getRequestDispatcher(srvViewPath + "/cesta.jsp");
                break;
            }
            //Para mostrar todos los productos
            default: {
                List<Producto> lp;
                lp = productoDAO.buscaTodos();
                request.setAttribute("productoDAO", lp);
                rd = request.getRequestDispatcher(srvViewPath + "/productos.jsp");
                break;
            }
        }
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        RequestDispatcher rd;

        //Detect current servlet action
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

        switch (action) {

            case "/productos": {
                Producto p;
                int id = Integer.parseInt(Util.getParam(request.getParameter("id"), "0"));
                p = productoDAO.buscaId(id);
                if (pedido == null) {
                    pedido = new ArrayList<>();
                }
                pedido.add(p);
                response.sendRedirect(srvUrl + "/productos");
                break;
            }
            case "/visualizaCategoria": {
                Producto p;
                int id = Integer.parseInt(Util.getParam(request.getParameter("id"), "0"));
                p = productoDAO.buscaId(id);
                if (pedido == null) {
                    pedido = new ArrayList<>();
                }
                pedido.add(p);
                response.sendRedirect(srvUrl + "/productos");
                break;
            }
            default: {
                response.sendRedirect(srvUrl);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
