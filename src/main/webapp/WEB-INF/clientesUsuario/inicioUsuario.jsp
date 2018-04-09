<%-- 
    Document   : inicioUsuario
    Created on : 08-abr-2018, 19:34:08
    Author     : Jose maria del Águlila López
    Author     : Rafel Galán Ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <title>Inicio - Usuario</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-md-offset-1">
                    <div class="well">
                        <p class="h4">Puedes ver tus datos desde aqui:</p>
                        <br>  
                        <center><a href='${srvUrl}/visualiza' ><button type="submit" class="btn btn-default"><p class="h4">Visualizar</p></button></a></center>
                    </div>
                </div>
                <div class="col-md-3 col-md-offset-1">
                    <div class="well">
                        <p class="h4">Puedes modificar tus datos desde aqui:</p>
                        <br>  
                        <center><a href='${srvUrl}/edita' ><button type="submit" class="btn btn-default"><p class="h4">Editar</p></button></a></center>
                    </div>
                </div>
                <div class="col-md-3 col-md-offset-1">
                    <div class="well">
                        <p class="h4">Puedes ver tus pedidos realizados desde aqui:</p>
                        <br>  
                        <center><a href='${srvUrl}/visualizaPedido' ><button type="submit" class="btn btn-default"><p class="h4">Visualizar Pedidos</p></button></a></center>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
