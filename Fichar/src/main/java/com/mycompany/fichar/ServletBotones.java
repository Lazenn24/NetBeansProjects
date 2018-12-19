/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
 * @author sergio
 */
@WebServlet(name = "ServletBotones", urlPatterns = {"/ServletBotones"})
public class ServletBotones extends HttpServlet {

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
            out.println("<title>Servlet ServletBotones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletBotones at " + request.getContextPath() + "</h1>");

            RequestDispatcher noLogin;

            // Para impedir entrar sin haberse logeado
            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("Debes loguearte primero");
                noLogin = request.getRequestDispatcher("index.html");
                noLogin.include(request, response);
            } else {
                
            UserSchedule registro;
            String fichar = request.getParameter("fichar");
            String logout = request.getParameter("logout");
            //String logout = request.getParameter("logout");
            RequestDispatcher tabla = request.getRequestDispatcher("/ServletTabla");
            RequestDispatcher falloFichar = request.getRequestDispatcher("/ServletMostrarHorarios");
            String user = (String) request.getSession().getAttribute("user");
            GregorianCalendar date = new GregorianCalendar();

            // Comprobar ultimo registro
            ArrayList<UserSchedule> horarioUsuario = new ArrayList<UserSchedule>();
            Hashtable<String, ArrayList<UserSchedule>> horarios = new Hashtable<String, ArrayList<UserSchedule>>();
            String sessionId = request.getSession().getId();
            String fallo = null;

            if (fichar.equals("Fichar entrada") && fichar != null) {
                // Para comprobar el tipo del ultimo registro 

                if (getServletContext().getAttribute("horario") != null) {
                    horarios = (Hashtable<String, ArrayList<UserSchedule>>) getServletContext().getAttribute("horario");
                    horarioUsuario = (ArrayList<UserSchedule>) horarios.get(sessionId);

                    if ((EntradaSalida) horarioUsuario.get(horarioUsuario.size() - 1).getTipo() == EntradaSalida.ENTRADA) {
                        fallo = "<p>Debes fichar salida antes</p>";
                        request.getSession().setAttribute("fallo", fallo);
                        falloFichar.forward(request, response);
                    }
                }
                registro = new UserSchedule(EntradaSalida.ENTRADA, user, date);

                request.getSession().setAttribute("registro", registro);
                tabla.forward(request, response);

            } else if (fichar.equals("Fichar salida") && fichar != null) {
                // Para comprobar el tipo del ultimo registro

                if (getServletContext().getAttribute("horario") != null) {
                    horarios = (Hashtable<String, ArrayList<UserSchedule>>) getServletContext().getAttribute("horario");
                    horarioUsuario = (ArrayList<UserSchedule>) horarios.get(sessionId);

                    if ((EntradaSalida) horarioUsuario.get(horarioUsuario.size() - 1).getTipo() == EntradaSalida.SALIDA) {
                        fallo = "<p>Debes fichar entrada antes</p>";
                        request.getSession().setAttribute("fallo", fallo);
                        falloFichar.forward(request, response);
                    }
                }
                registro = new UserSchedule(EntradaSalida.SALIDA, user, date);

                request.getSession().setAttribute("registro", registro);
                tabla.forward(request, response);
            }

            if (logout.equals("Cerrar sesion") && logout != null) {
                RequestDispatcher rdLogout = request.getRequestDispatcher("/index.html");
                rdLogout.include(request, response);
                session.invalidate();

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
