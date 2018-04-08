<%-- 
    Document   : ListadoClientes.jps
    Created on : 26-feb-2018, 19:04:27
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <title>Listado - Clientes</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class='container'>
            <c:choose>
                <c:when test="${not empty clientes}">
                    <table class="table table-striped">
                        <tr><th>ID</th><th>Correo</th><th>Apellidos</th><th>Nombre</th>
                            <th>Fecha de Nacimiento</th><th>Opciones</th></tr>
                                <c:forEach var="c" items="${clientes}">
                                    <c:set var="qry" value="?id=${c.id}"/>
                            <tr>
                                <td>${c.id}</td>
                                <td>${c.correo}</td>
                                <td>${c.nombre}</td>
                                <td>${c.apellidos}</td>
                                <td>${c.fNac}</td>
                                <td>
                                    <a class='btn btn-default' href='${srvUrl}/edita${qry}'>Editar</a>&nbsp;
                                    <a class='btn btn-default' href='${srvUrl}/borra${qry}'>Borrar</a>&nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:when test="${empty clientes}">
                    <h1>No hay clientes registrados</h1>
                </c:when>
            </c:choose>
            <center><a href='${srvUrl}' ><button type="submit" class="btn btn-default"><p class="h4">Volver</p></button></a></center>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
