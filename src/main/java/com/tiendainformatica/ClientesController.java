/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendainformatica;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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

/**
 *
 * @author delag
 */
@WebServlet("/clientes/*")
public class ClientesController extends HttpServlet {

    private ClienteDAO clientes;
    private final String srvViewPath = "/WEB-INF/clientes";
    private String srvUrl;
    private static final Logger Log = Logger.getLogger(ProductosController.class.getName());

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        srvUrl = servletConfig.getServletContext().getContextPath() + "/clientes";
        clientes = new ClienteDAOList();

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

        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        Log.log(Level.INFO, "Petición GET {0}", action);

        switch (action) {
            case "/crea":
                Cliente c = new Cliente();
                request.setAttribute("cliente", c);
                rd = request.getRequestDispatcher(srvViewPath + "/registro.jsp");
                break;
            case "/listado":
                List<Cliente> lc = clientes.buscaTodos();
                request.setAttribute("clientes", lc);
                rd = request.getRequestDispatcher(srvViewPath + "/listadoClientes.jsp");
                break;
            default:
                rd = request.getRequestDispatcher(srvViewPath + "/perfil.jsp");
                break;
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
            case "/crea": {     //ALTA DE UN CLIENTE
                Cliente c = new Cliente();
                if (validateCustomer(request, c)) {
                    clientes.crea(c); //Create new client
                    //Post-sent-redirect
                    Log.log(Level.INFO, "Petición GET {0}", action);
                    response.sendRedirect(srvUrl + "/listado");
                } else { //Show form with validation errores
                    request.setAttribute("cliente", c);
                    rd = request.getRequestDispatcher(srvViewPath + "/registro.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            default: {
                response.sendRedirect(srvUrl);
            }
        }
    }

    private boolean validateCustomer(HttpServletRequest request, Cliente c) {
        boolean valido = true;
        //Capturamos y convertimos datos
        int id = Integer.parseInt(Util.getParam(request.getParameter("id"), "0"));
        String nombre = Util.getParam(request.getParameter("nombre"), "");
        String apellidos = Util.getParam(request.getParameter("apellidos"), "");
        String correo = Util.getParam("correo", "");
        String fNac = Util.getParam(request.getParameter("fnac"), "");

        //Asignamos datos al bean
        c.setId(id);
        c.setNombre(nombre);
        c.setApellidos(apellidos);
        c.setCorreo(correo);
        c.setfNac(fNac);
        //Validamos Datos
        if (nombre.length() < 3 || nombre.length() > 50) {
            request.setAttribute("errNombre", "Nombre no válido");
            Log.log(Level.INFO, "Enviado Nombre de usuario no válido");
            valido = false;
        }
        return valido;
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
