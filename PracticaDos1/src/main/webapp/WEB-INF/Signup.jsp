<%-- 
    Document   : signup
    Created on : 05-dic-2018, 15:52:14
    Author     : thepinguin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1>Signup</h1>
        
        <form method="POST" action="ServletFormulario">
        <label for="user">User</label> </br>
        <input id="user" type="text" name="user"/></br>
        <label for="contra">Contraseña:</label></br>
        <input id="pass" type="password" name="password"/></br>
        <label for="mail">Mail</label></br>
        <input id="mail" type="text" name="mail"/></br>
        </br>        
        <input type="submit"/>
        </form>

