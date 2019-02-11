<%-- 
    Document   : login
    Created on : 10-dic-2018, 16:02:12
    Author     : thepinguin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1>Login</h1>
        
        <form method="POST" action="ServletLogin">
        <label for="user" >User</label> </br>
        <input id="user" type="text" name="user"/></br>
        <label for="contra">Contraseña:</label></br>
        <input id="pass" type="password" name="password"/></br></br>
        <input type="submit"/></br>
        </form>
