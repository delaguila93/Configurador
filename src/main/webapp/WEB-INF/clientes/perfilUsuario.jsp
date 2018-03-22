<%-- 
    Document   : perfilUsuario.jsp
    Created on : 26-feb-2018, 19:14:36
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configurador - Perfil</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
                <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="well">
                        <center><img src="${pageContext.request.contextPath}/imagenes/perfil.jpg" height="200" width="200" class="img-responsive img-rounded"></center>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="well center-block">
                        <form method="POST">
                            <label><p class="h4">Correo</p></label><input name="correo" value="${cliente.correo}" class="form-control" type="email">
                            <label><p class="h4">Nombre</p></label><input name="nombre" value="${cliente.nombre}" class="form-control">
                            <label><p class="h4">Apellidos</p></label><input name="apellidos" value="${cliente.apellidos}" class="form-control">
                            <label><p class="h4">Fecha de nacimiento</p></label><input name="fnac" value="${cliente.fNac}" class="form-control" type="date">
                            <br>
                            <center><input name="enviar" type="submit" class="btn btn-default btn-lg" value="Modificar"></center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>      
    </body>
</html>
