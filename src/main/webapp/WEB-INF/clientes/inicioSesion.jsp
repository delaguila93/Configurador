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
                        <form action="j_security_check" method="POST">
                            <c:if test="${param.error!=null}"> <span class="label label-danger">Vuelve a introducir tus credenciales</span></c:if>
                                <label><p class="h4">Correo</p></label> <input name="j_username" value="" class="form-control">
                                <label><p class="h4">Contraseña</p></label><input name="j_password" value="" class="form-control" type="password">
                                <br>
                                <center><input type="submit" class="btn btn-default" value="Iniciar Sesion"><p class="h4"></p></button></a></center>
                            </form>

                        </div>

                    </div>
                </div>

            </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
