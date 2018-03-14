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
                    <div class="container">
                        <div class="row">
                            
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>          
    </body>
</html>
