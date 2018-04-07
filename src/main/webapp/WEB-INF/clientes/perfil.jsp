<%-- 
    Document   : perfil.jps
    Created on : 26-feb-2018, 18:46:39
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>

        <div class="container">
            <div class="row">
                <c:if test="${empty pageContext.request.remoteUser}">
                    <div class="col-md-3 col-md-offset-2">
                        <div class="well">
                            <p class="h4">Para acceder a la plataforma como socio:</p>
                            <br><br>  
                            <center><a href='${srvUrl}/inicioSesion' ><button type="submit" class="btn btn-default"><p class="h4">Iniciar Sesión</p></button></a></center>
                        </div>
                    </div>
                    <div class="col-md-3 col-md-offset-1">
                        <div class="well">
                            <p class="h4">Para registrarse como socio en la plataforma:</p>
                            <br><br>  
                            <center><a href='${srvUrl}/crea' ><button type="submit" class="btn btn-default"><p class="h4">Registro</p></button></a></center>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty pageContext.request.remoteUser}">
                    <c:if test ="${pageContext.request.isUserInRole('ADMINISTRADOR')}">
                        <div class="col-md-3 col-md-offset-3">
                            <div class="well">
                                <p class="h4">De manera temporal se puede ver el listado de socios de la pagina:</p>
                                <br>  
                                <center><a href='${srvUrl}/listado' ><button type="submit" class="btn btn-default"><p class="h4">Listado</p></button></a></center>
                            </div>
                        </div>
                    </c:if>
                    <c:if test ="${pageContext.request.isUserInRole('USUARIO')}">
                        <div class="col-md-3 col-md-offset-2">
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
                    </c:if>
                    <div class="col-md-3 col-md-offset-3">
                        <div class="well">
                            <p class="h4">Puedes ver tus pedidos realizados desde aqui:</p>
                            <br>  
                            <center><a href='${srvUrl}/visualizaPedido' ><button type="submit" class="btn btn-default"><p class="h4">Visualizar Pedidos</p></button></a></center>
                        </div>
                    </div>

                </c:if>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
