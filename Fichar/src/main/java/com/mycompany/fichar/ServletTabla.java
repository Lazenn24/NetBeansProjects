/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
@WebServlet(name = "ServletTabla", urlPatterns = {"/ServletTabla"})
public class ServletTabla extends HttpServlet {

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
            out.println("<title>Servlet ServletTabla</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTabla at " + request.getContextPath() + "</h1>");

            ArrayList<UserSchedule> horarioUsuario = new ArrayList();
            Hashtable<String, ArrayList<UserSchedule>> horarios = new Hashtable();
            RequestDispatcher rd = request.getRequestDispatcher("/ServletHorarios");

            // Meter sessionId en key de hashtable
            String sessionId = request.getSession().getId();
            String user = (String) request.getSession().getAttribute("user");
            UserSchedule guardar = (UserSchedule) request.getAttribute("registro");
            
            horarioUsuario.add(guardar);
            horarios.put(sessionId, horarioUsuario);
            getServletContext().setAttribute("horario", horarios);
            rd.forward(request, response);
            
            /*if (request.getAttribute("inicio") == entrada) {
                uS.setId(sessionId);
                uS.setEntrada(getHora());
                horarioUsuario.add(uS);
                horarios.put(user, uS);
                getServletContext().setAttribute("horario", horarios);
                rd.forward(request, response);
            } else if (request.getAttribute("fin") == salida) {
                uS.setId(user);
                rd.forward(request, response);
            } */           
            
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
