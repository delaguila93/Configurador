/**
 * @file   Login.java
 * @Author Jose María del Águila López
 * @Author Rafael Galán Ruiz
 */
package com.tiendainformatica;

import com.tiendainformatica.dao.ClienteDAO;
import com.tiendainformatica.dao.PedidoDAO;
import com.tiendainformatica.dao.ProductoDAO;
import com.tiendainformatica.jdbc.ClienteDAOJdbc;
import com.tiendainformatica.jdbc.PedidoDAOJdbc;
import com.tiendainformatica.jdbc.ProductoDAOJdbc;
import com.tiendainformatica.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author delag
 */
@WebServlet(name = "Login", urlPatterns = {"/clientes/*"})
public class Login extends HttpServlet {

    private ClienteDAO clientes;
    private PedidoDAO pedidos;
    private ProductoDAO productos;
    private final String srvViewPath = "/WEB-INF/clientes";
    private String srvUrl;
    private static final Logger Log = Logger.getLogger(ProductosController.class.getName());

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        srvUrl = servletConfig.getServletContext().getContextPath() + "/clientes";
        clientes = new ClienteDAOJdbc();
        pedidos = new PedidoDAOJdbc();
        productos = new ProductoDAOJdbc();

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

            case "/crea": {
                Cliente c = new Cliente();
                request.setAttribute("cliente", c);
                rd = request.getRequestDispatcher(srvViewPath + "/registro.jsp");
                break;
            }
            case "/inicioSesion": {
                if (request.isUserInRole("ADMINISTRADOR")) {
                    rd = request.getRequestDispatcher("/clientesAdmin/inicioAdmin.jsp");
                } else if (request.isUserInRole("USUARIO")) {
                    rd = request.getRequestDispatcher("/");
                }
                break;
            }
            default:
                if (request.getRemoteUser() == null) {
                    rd = request.getRequestDispatcher(srvViewPath + "/perfil.jsp");
                } else if (request.isUserInRole("USUARIO")) {
                    rd = request.getRequestDispatcher("/clientesUsuario/inicioUsuario.jsp");
                } else if (request.isUserInRole("ADMINISTRADOR")) {
                    rd = request.getRequestDispatcher("/clientesAdmin/inicioAdmin.jsp");
                }
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
            case "/crea": {
                Cliente c = new Cliente();
                if (validarCliente(request, c)) {
                    clientes.crea(c);
                    //Post-sent-redirect
                    response.sendRedirect(request.getContextPath());
                } else {
                    request.setAttribute("cliente", c);
                    rd = request.getRequestDispatcher(srvViewPath + "/registro.jsp");
                    rd.forward(request, response);
                }
                break;
            }
        }
    }

    private boolean validarCliente(HttpServletRequest request, Cliente c) {
        boolean valido = true;
        //Capturamos y convertimos datos

        int id = Integer.parseInt(Util.getParam(request.getParameter("id"), "0"));
        String nombre = Util.getParam(request.getParameter("nombre"), "");
        String clave = Util.getParam(request.getParameter("clave"), "");
        String apellidos = Util.getParam(request.getParameter("apellidos"), "");
        String correo = Util.getParam(request.getParameter("correo"), "");
        String fNac = Util.getParam(request.getParameter("fnac"), "");

        //Asignamos datos al Cliente
        c.setId(id);
        c.setCorreo(correo);
        c.setClave(clave);
        c.setNombre(nombre);
        c.setApellidos(apellidos);
        c.setfNac(fNac);
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        //Validamos Datos
        if (nombre.length() < 3 || nombre.length() > 50) {
            request.setAttribute("errNombre", "Nombre no válido");
            Log.log(Level.INFO, "Enviado Nombre de usuario no válido");
            valido = false;
        }
        if (action == "/crea") {
            if (clientes.comprobarCorreo(correo) == true) {
                request.setAttribute("errCorreo", "Ese correo ya existe");
                Log.log(Level.INFO, "Enviado Correo no valido");
                valido = false;
            }
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
