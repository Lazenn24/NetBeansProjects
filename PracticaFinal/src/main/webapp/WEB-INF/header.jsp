<%-- 
    Document   : header
    Created on : 21-ene-2019, 17:45:06
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 style="text-align: center">Fichar</h1>
<% if (request.getSession().getAttribute("user") == null) {%>
    <div class="header" style="text-align: right">
        <form action="Redirect" method="POST">
            <button type="submit" name="boton" value="login">Iniciar sesión</button>
        </form>
        <form action="Redirect" method="POST">
            <button type="submit" name="boton" value="signup">Registrarse</button>
        </form>
    </div>
<% } else {
    String user =(String) request.getSession().getAttribute("user");%>
    <div class="header" style="text-align: right">
        <p>Bienvenido, <%= user %></p>
        <form action="LogOut" method="POST">
            <button>Salir de la sesión</button>
        </form>
    </div>
        <%}%>
    <hr>