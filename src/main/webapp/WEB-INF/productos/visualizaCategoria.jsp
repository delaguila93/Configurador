<%-- 
    Document   : productosCategoria
    Created on : 12-mar-2018, 14:05:02
    Author     : delag
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaInformatica</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar" 
                     <ul class="nav flex-colum">                         
                        <div class="btn-group-vertical">   
                            <c:forEach var="m" items="${categorias}">
                                <center><a href='${srvUrl}/visualizaCategoria?categoria=${m}' class="btn btn-default" style='width:170px; height:50px'><p class="h5">${m}</p></a></center>
                                    </c:forEach>
                        </div>
                    </ul>
                </nav>
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px4">
                    <c:choose>
                        <c:when test="${not empty productosCategoria}">
                            <div class="container">
                                <div class="row">                              
                                    <c:forEach var="p" items="${productosCategoria}">
                                        <c:set var="qry" value="?id=${p.id}"/>                  
                                        <div class="col-md-3" align="center">
                                            <div class="card" style="width: 18rem;">
                                                <img class="card-img-top" src="${pageContext.request.contextPath}/imagenes/${p.id}.jpg" alt="Card image cap">
                                                <div class="card-body">
                                                    <h4 class="card-title">${p.nombre}</h4>
                                                    <p class="h5">${p.descripcion}</p>
                                                    <p class="h5">${p.precio} €</p>                                       
                                                    <a href='${srvUrl}/anadeProducto${qry}' class="btn btn-default" <p class="h4" >Añadir cesta</p></a> 
                                                </div>
                                            </div>
                                            <br>        
                                        </div>
                                    </c:forEach>                               
                                </div>                        
                            </div>
                        </c:when>
                        <c:when test="${empty productosCategoria}">
                            <h1>No hay productos</h1>
                        </c:when>
                    </c:choose>
                </main>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>          
    </body>
</html>
