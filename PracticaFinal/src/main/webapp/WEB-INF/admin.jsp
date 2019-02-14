<%-- 
    Document   : admin
    Created on : 14-feb-2019, 19:19:08
    Author     : admin
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
        <h3>Horarios</h3>
        <% List<Object[]> horarios = (List<Object[]>) request.getAttribute("horario");
            if (horarios != null) {%>
        <table border="1">
            <th>USUARIO</th>
            <th>TIPO</th>
            <th>FECHA</th>
                <%for (Object[] obj : horarios) {%>
            <tr>
                <td>
                    <%=obj[0]%>
                </td>
                <td>
                    <%=obj[1]%>
                </td>
                <td>
                    <%=obj[2]%>
                </td>
            </tr>
            <%}
                }%>
            <%@include file="footer.jsp" %>

    </body>
</html>
