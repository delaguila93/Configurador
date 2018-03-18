<%--
    Document   : productos.jsp
    Created on : 23-feb-2018, 14:00:49
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>


        <%-- <p:choose>
            <p:when test="${not empty producto}">
                <p:forEach var="p" items="${producto}">
                    <p:set var="qry" value="?id=${p.id}"/>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3" align="center">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="${p.imagen}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title">${p.nombre}</h4>
                                        <p class="h5">${p.descripcion}</p>
                                        <p class="h5">${p.precio} €</p>
                                        <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                    </div>
                                </div>
                            </div>            
                        </div>
                        <br>
                    </div>

                </p:forEach>
            </p:when>
            <p:when test="${empty producto}">
                <h1>No hay productos</h1>
            </p:when>
        </p:choose>--%>

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
                    <p:choose>
            <p:when test="${not empty producto}">
                <div class="container">
                    <div class="row">
                        <p:forEach var="p" items="${producto}">
                        <p:set var="qry" value="?id=${p.id}"/>                  
                        <div class="col-md-3" align="center">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="${p.imagen}" alt="Card image cap">
                                <div class="card-body">
                                    <h4 class="card-title">${p.nombre}</h4>
                                    <p class="h5">${p.descripcion}</p>
                                    <p class="h5">${p.precio} €</p>
                                    <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                </div>
                            </div>
                            <br>        
                        </div>
                        
                        </p:forEach>
                        </div>                        
                    </div>

                
            </p:when>
            <p:when test="${empty producto}">
                <h1>No hay productos</h1>
            </p:when>
        </p:choose>

                </main>
            </div>
        </div>
    
    <%@include file="/WEB-INF/jspf/pie.jspf" %>       
</body>
</html>
        
