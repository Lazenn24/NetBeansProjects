<%-- 
    Document   : index.jsp
    Created on : 21-ene-2019, 17:53:54
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <p>Bienvenido al sistema de fichaje de entradas y salidas</p>
        <% String error = (String) request.getAttribute("error");
        if(error != null){%>
        <p><%= error%></p>
        <%}%>
        <%@include file="/WEB-INF/footer.jsp" %>
    </body>
</html>
