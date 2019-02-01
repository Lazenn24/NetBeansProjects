<%-- 
    Document   : horarios
    Created on : 21-ene-2019, 20:10:34
    Author     : sergio
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.practicafinal.database.Entities.Schedule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>HORARIOS</h1>
        <form method="POST" action="Botones">
            <input type='submit' name='boton' value='Fichar entrada'>
            <input type='submit' name='boton' value='Fichar salida'>
        </form>
       
        
        <% List<Schedule> horarios = (List<Schedule>) request.getAttribute("horario"); 
            if(horarios != null){%>
            <table border="1">
                <th>TIPO</th>
                <th>FECHA</th>
                <% for(Schedule sc: horarios){%>
                <tr>
                    <td>
                        <%=sc.getTypeOfRegister()%>
                    </td>
                    <td>
                        <%=sc.getDate()%>
                    </td>
                </tr>
                <% }
            }%>
            </table>
            <% String error = (String) request.getAttribute("error");
            if(error != null){%>
            <p><%=error%></p>
            <%}%>
       
        <%@include file="footer.jsp" %>   
            
    </body>
</html>
