/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.servlets;

import static com.mycompany.practicafinal.database.CRUD.Crud.getSchedule;
import java.io.IOException;
import java.io.PrintWriter;
import static com.mycompany.practicafinal.database.CRUD.Crud.getUserId;
import static com.mycompany.practicafinal.database.CRUD.Crud.punchIn;
import com.mycompany.practicafinal.database.Entities.Schedule;
import com.mycompany.practicafinal.database.Entities.User;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objects.EntradaSalida;

/**
 *
 * @author admin
 */
public class Botones extends HttpServlet {

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
            String boton = request.getParameter("boton");

            if (boton.equals("Fichar entrada")) {
                int id = getUserId((String) request.getSession().getAttribute("user"));
                Schedule schedule = new Schedule();
                schedule.setUser(new User(id));
                schedule.setTypeOfRegister("ENTRADA");
                schedule.setDate(new Date());
                punchIn(schedule);
                request.setAttribute("horario", getSchedule(new User(id)));
                request.getRequestDispatcher("horarios.jsp").forward(request, response);
            } else if (boton.equals("Fichar salida")) {
                int id = getUserId((String) request.getSession().getAttribute("user"));
                Schedule schedule = new Schedule();
                schedule.setUser(new User(id));
                schedule.setTypeOfRegister("SALIDA");
                schedule.setDate(new Date());
                punchIn(schedule);
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
