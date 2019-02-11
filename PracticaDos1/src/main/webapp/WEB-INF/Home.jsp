<%-- 
    Document   : Layout
    Created on : 07-dic-2018, 18:58:10
    Author     : thepinguin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <%@page import="com.mycompany.practicauno.datamodel.entities.*"%>
    <%@page import="java.util.*"%>
    <%@page import="java.io.*"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <h1>Bienvenido al registro de horas</h1>
    <center>

        <form id="entrada" method="POST" action="ServletEntrada">
            <input type="submit" value="ENTRADA" id="entrada"  name="entrada"/>
        </form>

        <form id="salida" method="POST" action="ServletSalida">
            <input type="submit" value="SALIDA" id="salida"  name="salida"/>
        </form>

        <table border="1">
            <tr>
                <th>Fecha</th>
                <th>Tipo</th>
            </tr>

            <%

                List<Registros> reg = (List<Registros>) request.getAttribute("datos");
                
                if (reg != null) {
                    for (Registros r : reg) {

                        out.println("<tr>");
                        out.println("<th>" + r.getFecha() + "</th>");
                        out.println("<th >" + r.getTipo() + "</th>");
                        out.println("</tr>");

                    }
                }


            %>
        </table>
            <%
                
                ArrayList horas = (ArrayList) request.getAttribute("media");
                out.println("<h5> Media de horas: "+ horas.get(0) +"</br>Media de minutos: "+ horas.get(1)+""
                        + "</br>Media de segundos "+ horas.get(2)+"</h5>");
                %>
    </center>
</div>