/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import objects.UserSchedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletMostrarHorarios", urlPatterns = {"/ServletMostrarHorarios"})
public class ServletMostrarHorarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletHorarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletHorarios at " + request.getContextPath() + "</h1>");

            out.println("<form action='ServletBotones' method='POST'>");
            out.println("<input type='submit' name='boton' value='Fichar entrada'>");
            out.println("<input type='submit' name='boton' value='Fichar salida'>");
            out.println("<br>");
            out.println("<input type='submit' name='boton' value='Cerrar sesion'>");

            out.println("</form>");


            // Para impedir entrar sin haberse logeado
            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("Debes iniciar sesión primero");
                RequestDispatcher noLogin = request.getRequestDispatcher("index.html");
                noLogin.forward(request, response);

            } else {
                /*if(request.getSession().getAttribute("login") != null && (boolean) request.getSession().getAttribute("login") == false) {
                RequestDispatcher volverLogin = request.getRequestDispatcher("/index.html");
                volverLogin.forward(request, response);
            }*/

                Hashtable<String, ArrayList<UserSchedule>> horarios;
                ArrayList<UserSchedule> horarioUsuario;
                //String user = request.getSession().getId();
                String user;
                String fallo = (String) request.getSession().getAttribute("fallo");

                if (getServletContext().getAttribute("horario") != null) {
                    // Al estar el arraylist con la key de la sesion, se muestra la misma tabla de horarios para todos los usuarios.
                    // Si cambio la key al nombre de usuario, la tabla cambia.
                    user = (String) request.getSession().getAttribute("user");
                    horarios = (Hashtable) request.getServletContext().getAttribute("horario");
                    horarioUsuario = (ArrayList) horarios.get(user);
                    out.println("<table border='1px solid black'>");
                    for (UserSchedule uS : horarioUsuario) {
                        out.println("<tr>");
                        out.println("<td>" + uS.getTipo() + "</td><td>" + uS.getUser() + "</td><td>" + uS.getCalendar().getTime() + "</td></tr>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    if (fallo != null) {
                        out.println(fallo);
                    }
                }

                out.println("</body>");
                out.println("</html>");
            }

        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
