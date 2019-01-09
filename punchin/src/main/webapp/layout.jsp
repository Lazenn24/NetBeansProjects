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
                <form action="ServletBotonesPrueba" method="POST">
                    <input type="submit" name="boton" value="Iniciar sesion">
                    <input type="submit" name=boton value="Registrarse">
                </form>
            </div>
        </div>
        <hr>
        <div id="body">
            <%-- Escribe un if que compruebe que exoiste el parametro de boton, encapuslalo todo dentro de este if crack, fiera , mastodonte--%>
            <%if (request.getParameter("boton") != null) {
                    String boton = request.getParameter("boton");
                    if (boton.equals("Iniciar sesion")) { %>
            <jsp:include page="login.jsp"/>
            <% } else if (boton.equals("Registrarse")) {%>
            <jsp:include page="registro.jsp"/>
            <% } else {%>
            <h1>Bienvendo al sistema de fichaje</h1>
            <% }
                }%>
        </div>
    </body>
</html>
