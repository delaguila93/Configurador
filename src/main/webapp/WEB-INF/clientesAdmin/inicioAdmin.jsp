<%-- 
    Document   : inicioAdmin
    Created on : 08-abr-2018, 19:46:32
    Author     : Jose maria del Águlila López
    Author     : Rafel Galán Ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <title>Inicio - Admin</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-md-offset-3">
                    <div class="well">
                        <p class="h4">Ver el listado de socios de la pagina:</p>
                        <br>  
                        <center><a href='${srvUrl}/listado' ><button type="submit" class="btn btn-default"><p class="h4">Listado</p></button></a></center>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
