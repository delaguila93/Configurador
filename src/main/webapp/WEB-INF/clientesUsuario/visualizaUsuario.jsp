<%-- 
    Document   : inicioSesion.jps
    Created on : 26-feb-2018, 19:04:27
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <title>Inicio sesion</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="well center-block">
                        <label><p class="h4">Correo:${cliente.correo}</p></label><br>
                        <label><p class="h4">Nombre:${cliente.nombre}</p></label><br>
                        <label><p class="h4">Apellidos:${cliente.apellidos}</p></label><br>
                        <label><p class="h4">Fecha de Nacimiento:${cliente.fNac}</p></label><br>
                        <a class='btn btn-default' href='${srvUrl}/edita'>Editar</a>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
