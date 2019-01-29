<%-- 
    Document   : login
    Created on : 21-ene-2019, 17:50:06
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
        <fieldset>
            <legend>
                Login
            </legend>
            <form action="Login" method="POST">
                <label>Usuario: </label>
                <input type="text" name="user"/>
                <br /><br />
                <label>Contraseña:</label>
                <input type="password" name="pass" /><br />
                <input type="reset" value="Vacíar campos" />
                <input type="submit" name="submit" value="Entrar"/>
            </form>
        </fieldset>

        <div id="error">
            <%  String error = (String) request.getAttribute("info");
                if (error != null) { %>
                   <p><%= error%></p>
            <%}%>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
