<%-- 
    Document   : cesta.jps
    Created on : 04-mar-2018, 19:00:23
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesta</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>

        <div class="container">
            <div class="row">
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px4">
                    <div class="container">
                        <c:choose>
                            <c:when test="${not empty pedido}">
                                <p:forEach var="cat" items="${categorias}">
                                    <c:forEach var="p" items="${pedido}">
                                        <p:if test="${cat == p.categoria}">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="col-md-2">
                                                        <img class="card-img-top" src="${pageContext.request.contextPath}/imagenes/${p.categoria}/${p.id}.jpg" alt="Card image cap">
                                                    </div>
                                                    <div class="col-md-9 ml-sm-auto col-lg-10 pt-3 px4">
                                                        <div class="row">
                                                            <h4 class="card-title">${p.nombre}</h4>
                                                            <p class="h5">${p.descripcion}</p>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <p class="h3">Precio: ${p.precio}€</p>
                                                            </div>                                                   
                                                        </div>
                                                    </div>
                                                </div>
                                        </p:if>
                                    </c:forEach>
                                </p:forEach>
                            </c:when>
                            <c:when test="${empty pedido}">
                                <h4>No ha productos para comprar</h4>
                            </c:when>

                        </c:choose>
                    </div>



                </main>
                <nav class="col-md-2 d-none d-md-block bg-light sidebar"> 

                    <div class="btn-group-vertical">   
                        <p class="h3">Total de la compra</p>
                        <p class="h3">${p.precio}</p>

                    </div>


                </nav>

            </div>
        </div>

        <%@include file="/WEB-INF/jspf/pie.jspf" %>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>       
        <script src="https://getbootstrap.com/assets/js/vendor/popper.min.js"></script>
        <script src="https://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <script src="https://getbootstrap.com/assets/js/vendor/holder.min.js"></script>
    </body>
</html>
