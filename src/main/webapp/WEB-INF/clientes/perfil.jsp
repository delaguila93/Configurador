<%-- 
    Document   : perfil.jps
    Created on : 26-feb-2018, 18:46:39
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                    <div class="col-md-3 col-md-offset-2">
                        <div class="well">
                            <p class="h4">Para acceder a la plataforma como socio:</p>
                            <br><br>  
                            <center><a href='${srvUrl}/inicioSesion' ><button type="submit" class="btn btn-default"><p class="h4">Iniciar Sesión</p></button></a></center>
                        </div>
                    </div>
                    <div class="col-md-3 col-md-offset-1">
                        <div class="well">
                            <p class="h4">Para registrarse como socio en la plataforma:</p>
                            <br><br>  
                            <center><a href='${srvUrl}/crea' ><button type="submit" class="btn btn-default"><p class="h4">Registro</p></button></a></center>
                        </div>
                    </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
