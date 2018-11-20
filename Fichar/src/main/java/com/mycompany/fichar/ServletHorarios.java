/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletHorarios", urlPatterns = {"/ServletHorarios"})
public class ServletHorarios extends HttpServlet {

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

            RequestDispatcher tabla = request.getRequestDispatcher("/ServletTabla");
            RequestDispatcher showTable = request.getRequestDispatcher("/horarios.html");

            Hashtable horarios;
            ArrayList<UserSchedule> horarioUsuario;
            String user = (String) request.getSession().getAttribute("user");

            if (request.getParameter("entrada") != null) {
                entradaSalida entrada = entradaSalida.ENTRADA;
                request.setAttribute("inicio", entrada);
                tabla.forward(request, response);
            }

            if (request.getParameter("salida") != null) {
                entradaSalida salida = entradaSalida.SALIDA;
                request.setAttribute("fin", salida);
                tabla.forward(request, response);
            }

            horarios = (Hashtable) request.getServletContext().getAttribute("horario");
            horarioUsuario = (ArrayList) horarios.get(user);
            
            showTable.include(request, response);
            
            for (UserSchedule uS : horarioUsuario) {
                out.println("<p>Entrada: " + uS.getEntrada() + "    Salida: " + uS.getSalida());
            }

            out.println("</body>");
            out.println("</html>");
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
