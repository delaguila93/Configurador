<%-- 
    Document   : index.jps
    Created on : 26-feb-2018, 18:46:39
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <title>Configurador - Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                            <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active carousel-item-left">
                                <img class="first-slide" src="imagenes/a3.jpg" alt="First slide">
                                <div class="container">
                                    <div class="carousel-caption text-left">
                                        <h1>En ujadDAW podrás encontrar todos los producttos relacionados con la informática</h1>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item carousel-item-next carousel-item-left">
                                <img class="second-slide" src="imagenes/ordenador.jpg" alt="Second slide">
                                <div class="container">
                                    <div class="carousel-caption">
                                        <h1>Tenemos los mejores ordenadores</h1>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="third-slide" src="imagenes/gaming.jpg" alt="Third slide">
                                <div class="container">
                                    <div class="carousel-caption text-right">
                                        <h1>Tenemos una gran selección en gaming</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <br>
                    <h3 align="left">Puede encontrarnos en: <strong>Campus de las Lagunillas</strong></h3>
                    <h3 align="left">Edificio: <strong>A3</strong> Aula: <strong>183</strong></h3>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3153.070609364703!2d-3.7793216850442652!3d37.788384979756955!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6dd7abfa6a10df%3A0xf05fe5191735ab43!2sUniversidad+de+Ja%C3%A9n!5e0!3m2!1ses!2ses!4v1519939475109" width="550" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>       
        <script src="https://getbootstrap.com/assets/js/vendor/popper.min.js"></script>
        <script src="https://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <script src="https://getbootstrap.com/assets/js/vendor/holder.min.js"></script>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
