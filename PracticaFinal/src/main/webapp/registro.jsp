<%-- 
    Document   : registro
    Created on : 21-ene-2019, 17:49:30
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
                Registro
            </legend>
            <form action="Registro" method="POST">
                <label>Usuario:</label>
                <input type="text" name="user" />
                <br />
                <label>Correo electrónico:</label>
                <input type="text" name="email" />
                <br />
                <label>Confirma la correo electrónico:</label>
                <input type="text" name="email2" />
                <br />
                <label>Contraseña:</label>
                <input type="password" name="password" />
                <br />
                <label>Confirma la contraseña</label>
                <input type="password" name="password2" />
                <br />
                <input type="reset" value="Vacíar los campos" />
                <input type="submit" name="submit" value="Darse de alta" />
            </form>
        </fieldset>
        
        <div id="info">
            <% String info = (String) request.getAttribute("info");
               if(info != null){%>
               <p><%= info%></p>
            <%}%>
        </div>
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>
