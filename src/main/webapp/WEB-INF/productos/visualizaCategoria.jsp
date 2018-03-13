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
        <h1>${categoria}</h1>
        <%@include file="/WEB-INF/jspf/pie.jspf" %>          
    </body>
</html>
