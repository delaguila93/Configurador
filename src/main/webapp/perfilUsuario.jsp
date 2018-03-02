<%-- 
    Document   : perfilUsuario
    Created on : 26-feb-2018, 19:14:36
    Author     : delag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configurador - Perfil</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
                <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="well">
                        <center><img src="imagenes/perfil.jpg" height="200" width="200" class="img-responsive img-rounded"></center>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="well center-block">
                        <form method="POST">
                            <label>Correo</label><input name="correo" value="" class="form-control" type="email">
                            <label>Nombre</label><input name="nombre" value="" class="form-control">
                            <label>Apellidos</label><input name="apellidos" value="" class="form-control">
                            <label>Fecha de nacimiento</label><input name="fnac" value="" class="form-control" type="date">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/pie.jspf" %>      
    </body>
</html>
