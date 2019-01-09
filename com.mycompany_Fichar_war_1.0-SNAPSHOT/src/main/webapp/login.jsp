<%-- 
    Document   : login
    Created on : 08-ene-2019, 23:29:52
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
        <fieldset>
            <legend>
                Login
            </legend>
            <form action="ServletLogin" method="POST">
                <label>Usuario: </label>
                <input type="text" name="user"/>
                <br /><br />
                <label>Contraseña:</label>
                <input type="password" name="pass" /><br />
                <input type="reset" value="Vacíar campos" />
                <input type="submit" name="submit" value="Entrar"/>
            </form>
        </fieldset>
    </body>
</html>
