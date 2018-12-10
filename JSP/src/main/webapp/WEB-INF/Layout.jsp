<%-- 
    Document   : Layout.jsp
    Created on : 29-nov-2018, 19:55:23
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <h1>Hello World!</h1>
        <div>
            <jsp:include page="<%= ((String) request.getAttribute("action")) + ".jsp" %>" />
        </div>
        
    </body>
</html>
