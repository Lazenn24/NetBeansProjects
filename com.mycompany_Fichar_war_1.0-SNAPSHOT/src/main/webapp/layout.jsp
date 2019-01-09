<%-- 
    Document   : layout
    Created on : 08-ene-2019, 23:27:56
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fichar</title>
    </head>
    <body>
        <div>
            <div id="header" style="text-align:right">
                <p>Bienvenido</p>
                <form action="/servlets/ServletBotonesPrueba" method="POST">
                    <input type="submit" name="boton" value="Iniciar sesion">
                    <input type="submit" name=boton value="Registrarse">
                </form>
            </div>
        </div>
        <hr>
        <div id="body">
            <% if (request.getParameter("login") != null) { %>
            <jsp:include page="login.jsp"/>

            <% } else if (request.getParameter("registro") != null) {%>
            <jsp:include page="registro.jsp"/>
            <% } else {%>

            <h1>Bienvendo al sistema de fichaje</h1>
        </div>
    </body>
</html>
