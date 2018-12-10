<%-- 
    Document   : registro
    Created on : 10-dic-2018, 16:29:53
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Registro</title>
    </head>
    <body>
        <div id="registro">
            <h1>Registro de nuevo usuario</h1>
            <fieldset>
                <legend>
                    Registro
                </legend>
                <form action="ServletRegistro" method="POST">
                    <label>Usuario:</label>
                    <input type="text" name="user" />
                    <br />
                    <label>Correo electrónico:</label>
                    <input type="text" name="email" />
                    <br />
                    <label>Confirma la correo electrónico:</label>
                    <input type="text" name="confirmaEmail" />
                    <br />
                    <label>Contraseña:</label>
                    <input type="password" name="pass" />
                    <br />
                    <label>Confirma la contraseña</label>
                    <input type="password" name="confirmaPass" />
                    <br />
                    <input type="reset" value="Vacíar los campos" />
                    <input type="submit" name="submit" value="Darse de alta" />
                </form>
            </fieldset>
        </div>
    </body>
</html>
