<%-- 
    Document   : Layout
    Created on : 07-ene-2019, 19:31:59
    Author     : thepinguin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <style>
            .arriba{
                border: 1px solid black;
                
            }
            
            #login{
                float: right;
                margin: 10px;
            }
            #signup{
                float: right;
                margin: 10px;
            }
            #logout{
                float: right;
                margin: 10px;
            }
            
            .tot{
                margin: auto;
                width: 50%;
                border: 3px solid red;
                padding: 10px;
                text-align: center;
            }
            
        </style>
        
        <script>
            
            $(document).ready(function(){
                alert("Hola");
            $("#entrada")click(function(){
                $('#entrada').hide();
                $('#salida').show();
                
            });
            
            $("#salida")click(function(){
                $('#salida').hide();
                $('#entrada').show();
                
            });
            
    });
        </script>
        
    </head>
    <body>
        <h1>Web de registros</h1>
        <%@page import="com.mycompany.practicauno.servlet.*"%>
        
        <div class="arriba">
        
        <%
          //  Usuario us = (Usuario) session.getAttribute("log");
            
            if(session.getAttribute("log") == null){
                
            out.println("<form id=\"login\" method=\"POST\" action=\"ServletNoLogin\">");
            out.println("<input type=\"submit\" value=\"Login\" id=\"login\"  name=\"login\"/>");
            out.println("</form>");
            
            out.println("<form id=\"signup\" method=\"POST\" action=\"ServletNoSignup\">");
            out.println("<input type=\"submit\" value=\"Signup\" id=\"signup\"  name=\"signup\"/>");
            out.println("</form>");
            }else{
            
           // out.println("<h3>Hola " + us.getUserName() + "<h3>");
            out.println("<form id=\"log\" method=\"POST\" action=\"ServletLogOut\">");
            out.println("<input type=\"submit\" value=\"Log out\" id=\"logout\"  name=\"logout\"/>");
            out.println("</form>");
            }
            
            %>
            </div>
            
            <div class="tot">
            <jsp:include page="<%= ((String) request.getAttribute("pagina")) + ".jsp" %>"/>
            </div>
            
        
</html>
