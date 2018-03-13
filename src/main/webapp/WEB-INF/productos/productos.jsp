<%-- 
    Document   : productos.jsp
    Created on : 23-feb-2018, 14:00:49
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar" 
                     <ul class="nav flex-colum">
                         
                        <div class="btn-group-vertical">   
                            <c:forEach var="m" items="${categorias}">
                                <center><a href='${srvUrl}/visualizaCategoria' class="btn btn-default" style='width:170px; height:50px' name="categoria"><p class="h5">${m}</p></a></center>
                            </c:forEach>
                        </div>
                    </ul>

                </nav>
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px4">
                    <div class="container">
                        <div class=row>
                            <div class="col-md-3" align="center">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="imagenes/placaBase.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title">ASUS - Placa base</h4>
                                        <p class="h5">Placa de base para gaming con AURA Sync RGB LED, DDR4 3200MHz, M.2, USB 3.1 conector panel y tipo A/C</p>
                                        <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3" align="center">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="imagenes/amdRyzen.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title">AMD RYZEN 7</h4>
                                        <p class="h5">AMD RYZEN 7 1700- Procesador de 3.7 GHz, Socket AM4 con ventilador Wraith Spire incluido</p>
                                        <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3" align="center">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="imagenes/ram.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title">Ballistix Sport LT</h4>
                                        <p class="h5">Ballistix Sport LT 4GB DDR4 2400 MT/s (PC4-19200) SR x8 DIMM 288-Pin - BLS4G4D240FSE (Rojo)</p>
                                        <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3" align="center">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="imagenes/grafica.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title">ASUS - Tarjeta gráfica</h4>
                                        <p class="h5">ASUS STRIX-GTX1080-8G-GAMING - Tarjeta gráfica (Strix, NVIDIA GeForce GTX 1080, 8 GB, GDDR5X, DVI, HDMI, DP)</p>
                                        <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class=row>
                            <div class="col-md-3" align="center">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="imagenes/mando.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title">Logitech G29</h4>
                                        <p class="h5">Logitech G29 - Volante para simulación de carreras con pedales incluidos, compatible con PS4, PS3 y PC</p>
                                        <a href="#" class="btn btn-default"><p class="h4">Comprar</p></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                    </div> 
                </main>
            </div>
        </div>

        <%@include file="/WEB-INF/jspf/pie.jspf" %>       
    </body>
</html>
