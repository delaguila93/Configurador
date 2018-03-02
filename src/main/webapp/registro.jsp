<%-- 
    Document   : registro
    Created on : 26-feb-2018, 19:27:49
    Author     : delag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <title>Configurador - Registro</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <div class=" col-md-6 col-md-offset-3">
                    <div class="well center-block">                     
                        <form method="POST">
                            <label>Correo</label><input name="correo" value="" class="form-control" type="email">
                            <label>Nombre</label><input name="nombre" value="" class="form-control" >
                            <label>Apellidos</label><input name="apellidos" value="" class="form-control" >
                            <label>Fecha de nacimiento</label><input name="fnac"value="" class="form-control" type="date">
                            <label>Contraseña</label><input name="contraseña" value="" class="form-control" type="password">                           
                        </form>  
                        <br>
                        <a href="perfilUsuario.jsp" ><center><button type="submit" class="btn btn-default">Registro</button></center></a>
                    </div>                  
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
