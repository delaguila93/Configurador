<%-- 
    Document   : cesta.jps
    Created on : 04-mar-2018, 19:00:23
    Author     : José María del Águila López, Rafael Galán Ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesta</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>

        <div class="container">
            <div class="row">
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px4">
                    <div class="container">

                        <div class="card">

                            <div class="card-body">
                                <div class="col-md-2">
                                    <img class="card-img-top" src="imagenes/placaBase.jpg" alt="Card image cap">
                                </div>
                                <div class="col-md-9 ml-sm-auto col-lg-10 pt-3 px4">
                                    <div class="row">
                                        <h4 class="card-title">ASUS - Placa base</h4>
                                        <p class="h5">Placa de base para gaming con AURA Sync RGB LED, DDR4 3200MHz, M.2, USB 3.1 conector panel y tipo A/C</p>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <p class="h3">Precio</p>
                                        </div>
                                        <div class="col-md-4">
                                            <%--<div class="row">--%>
                                            <div class="col-md-6">
                                                <p class="h3">Cantidad</p>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="h3">
                                                    <div class="dropdown">
                                                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            1
                                                        </button>
                                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                            <a class="dropdown-item" href="#">2</a>
                                                            <a class="dropdown-item" href="#">3</a>
                                                            <a class="dropdown-item" href="#">4</a>
                                                        </div>
                                                    </div>
                                                </div> 
                                            </div>                                                
                                            <%--</div>--%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                </main>
                <nav class="col-md-2 d-none d-md-block bg-light sidebar"> 

                    <div class="btn-group-vertical">   
                        <p>total</p>


                    </div>


                </nav>
            </div>
        </div>

        <%@include file="WEB-INF/jspf/pie.jspf" %>

        
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>       
        <script src="https://getbootstrap.com/assets/js/vendor/popper.min.js"></script>
        <script src="https://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <script src="https://getbootstrap.com/assets/js/vendor/holder.min.js"></script>
    </body>
</html>
