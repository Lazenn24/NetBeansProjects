<%-- 
    Document   : horarios
    Created on : 21-ene-2019, 20:10:34
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
        <%@include file="header.jsp" %>
        <form method="POST" action="ServletBotones">
            <input type='submit' name='boton' value='Fichar entrada'>
            <input type='submit' name='boton' value='Fichar salida'>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
