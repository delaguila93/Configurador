<%-- 
    Document   : montaje
    Created on : 26-feb-2018, 13:35:56
    Author     : delag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configurador - Montaje</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
        <h2>Comience a montar su nueva bestia parda de ordenador:</h2>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Carcasa</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Nox Hummer MC USB 3.0 Negra</option>
                            <option value="2">Nox Hummer MC USB 3.0 Zero Edition Blanca</option>
                            <option value="3">Nox Pax Blue Edition USB 3.0</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Placa base</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">MSI X299 SLI Plus</option>
                            <option value="2">Gigabyte X299 UD4 Pro</option>
                            <option value="3">MSI X299 Gaming M7 ACK</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Disco duro HDD</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Seagate BarraCuda 3.5" 1TB SATA3</option>
                            <option value="2">WD Blue 1TB SATA3</option>
                            <option value="3">Seagate BarraCuda 3.5" 2TB SATA3</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Memoria Ram</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">G.Skill Aegis DDR4 2133 PC4-17000 4GB CL15</option>
                            <option value="2">G.Skill Ripjaws V Red DDR4 2400 PC4-19200 16GB 2x8GB CL15</option>
                            <option value="3">Crucial DDR4 2400 PC4-19200 8GB CL17</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Tarjeta grafica</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Gigabyte GeForce GTX 1050Ti OC WindForce 4GB GDDR5</option>
                            <option value="2">MSI GTX 1060 GAMING X 6GB GDDR5</option>
                            <option value="3">Asus Dual GTX 1060 OC 6GB GDDR5</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Fuente de Alimentacion</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Nfortec Scutum PSU Fuente de Alimentacion 650W</option>
                            <option value="2">Tacens Mars Gaming Vulcano 750W 80 Plus Silver Modular Rojo</option>
                            <option value="3">Nox Urano VX 650W 80+ Bronze 120MM PWM</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Disco duro SSD</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Samsung 850 Evo SSD Series 500GB SATA3</option>
                            <option value="2">Kingston A400 SSD 120GB</option>
                            <option value="3">Samsung 850 Evo SSD Series 250GB SATA3</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Procesador</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Intel Core i7-7820X 3.6Ghz BOX</option>
                            <option value="2">Intel Core i9-7900X 3.3Ghz BOX</option>
                            <option value="3">Intel Core i5-7640X 4.0Ghz BOX-</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Monitor</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Samsung S24D330H 24" LED</option>
                            <option value="2">Acer V226HQL 21.5" LED</option>
                            <option value="3">Samsung LS24F352F 23.5" LED FullHD Freesync</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Raton</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Newskill Nukite Ratón Gaming MMO/MOBA RGB 16000 DPI</option>
                            <option value="2">Tacens Mars Gaming MM116 Ratón Gaming 3200 DPI</option>
                            <option value="3">MSI Interceptor DS B1 Ratón Gaming 1600 DPI Negro</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                        
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Teclado</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Newskill Aura Teclado Mecánico RGB Switch Brown</option>
                            <option value="2">Tacens Mars Gaming MK4 Teclado Mecánico Gaming RGB Switch Blue</option>
                            <option value="3">Tacens Mars Gaming MK4 Teclado Mecánico Gaming RGB Switch Brown</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Altavoces</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                            <option value="1">Creative A60 Altavoces 2.0</option>
                            <option value="2">Woxter Big Bass 95</option>
                            <option value="3">Logitech Z333 Speaker 80W</option>
                        </select>
                        <h5>Precio: 20 Euros</h5>
                    </div>
                </div>
            </div>
            <h3>Total: 999.99 Euros</h3>
        </div>
        
    </body>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
</html>
