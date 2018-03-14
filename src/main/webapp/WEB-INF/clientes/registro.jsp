<%-- 
    Document   : registro.jsp
    Created on : 26-feb-2018, 19:27:49
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <title>Registro</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <div class=" col-md-6 col-md-offset-3">
                    <div class="well center-block">                     
                        <form method="POST">
                            <label><p class="h4">Correo</p></label><input name="correo" value="" class="form-control" type="email">
                            <label><p class="h4">Nombre</p></label><input name="nombre" value="" class="form-control" >
                            <label><p class="h4">Apellidos</p></label><input name="apellidos" value="" class="form-control" >
                            <label><p class="h4">Fecha de nacimiento</p></label><input name="fnac"value="" class="form-control" type="date">
                            <label><p class="h4">Contraseña</p></label><input name="contraseña" value="" class="form-control" type="password">                           
                        </form>  
                        <br>                     
                        <center><a href='${srvUrl}/listado'><button name="enviar" type="submit" class="btn btn-default" ><p class="h4">Registro</p></button></a></center>
                    </div>                  
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
