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
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <title>Inicio sesion</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">

            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="well center-block">
                        <form method="POST">
                            <label><p class="h4">Usuario</p></label> <input name="usuario" value="" class="form-control">
                            <label><p class="h4">Contraseña</p></label><input name="contraseña" value="" class="form-control" type="password">
                        </form>
                        <br>
                        <center><a href="perfilUsuario.jsp"> <button type="submit" class="btn btn-default"><p class="h4">Iniciar Sesion</p></button></a></center>
                    </div>

                </div>
            </div>

        </div>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
