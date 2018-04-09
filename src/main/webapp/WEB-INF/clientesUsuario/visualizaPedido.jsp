<%-- 
    Document   : visualizaPedido.jsp
    Created on : 06-abr-2018, 14:08:12
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class='container'>
            <c:choose>
                <c:when test="${not empty clientes}">
                    <table class="table table-striped">
                        <tr><th>IDPedido</th><th>Nombre producto</th><th>Precio</th><th>Cantidad</th>
                            <th>Estado</th></tr>
                                <c:forEach var="p" items="${pedidos}">
                                    <c:forEach var="nP" items="${nomProductos}">                                       
                                <tr>
                                    <td>${p.id}</td>
                                    <td>${nP}</td>
                                    <td>${p.precioTotal}</td>
                                    <td>${p.cantidad}</td>
                                    <td>${p.estado}</td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </table>
                </c:when>
                <c:when test="${empty pedidos}">
                    <h1>No has realizado pedidos</h1>
                </c:when>
            </c:choose>
            <center><a href='${srvUrl}' ><button type="submit" class="btn btn-default"><p class="h4">Volver</p></button></a></center>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
