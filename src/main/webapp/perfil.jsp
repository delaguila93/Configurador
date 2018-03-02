<%-- 
    Document   : perfil
    Created on : 26-feb-2018, 18:46:39
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
                <div class="col-md-3 col-md-offset-3">
                    <div class="well">
                        Adelante , está usted como en casa. Quítese los zapatos, pongase cómodo y prepare bien la cartera porque Steam a nuestro lado es un buen samaritano.
                        <br>
                        <center><a href="inicioSesion.jsp"><button type="submit" class="btn btn-primary">Iniciar Sesion</button></a></center>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="well">
                        Si por alguna casualidad de la vida y usted no es miembro de la comunidad de Configurador no dude en darle al boton de registro de abajo y únase a  esta, nuestra comunidad.
                        <br>
                        <center><a href="registro.jsp"><button type="submit" class="btn btn-primary ">Registrarse</button></a></center>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
